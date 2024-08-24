package mikes.dept.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import mikes.dept.data.database.BootCounterAppAppDatabase
import mikes.dept.data.mapper.toDb
import mikes.dept.data.mapper.toDomain
import mikes.dept.domain.entities.BootEventEntity
import mikes.dept.domain.repository.BootEventRepository
import javax.inject.Inject

class BootEventRepositoryImpl @Inject constructor(
    private val bootCounterAppAppDatabase: BootCounterAppAppDatabase
) : BootEventRepository {

    override fun observeAllBootEvents(): Flow<List<BootEventEntity>> = bootCounterAppAppDatabase.bootEventDao().observeAll()
        .map { list ->
            list?.map { bootEventDBEntity -> bootEventDBEntity.toDomain() } ?: listOf()
        }
        .flowOn(Dispatchers.IO)

    override suspend fun insertBootEvent(bootEventEntity: BootEventEntity) {
        bootCounterAppAppDatabase.bootEventDao().insert(bootEventDBEntity = bootEventEntity.toDb())
    }

}
