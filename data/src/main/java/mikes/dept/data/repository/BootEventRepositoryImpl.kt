package mikes.dept.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import mikes.dept.data.database.BootCounterAppAppDatabase
import mikes.dept.data.mapper.toDb
import mikes.dept.data.mapper.toDomain
import mikes.dept.domain.entities.BootEventEntity
import mikes.dept.domain.repository.BootEventRepository
import javax.inject.Inject

class BootEventRepositoryImpl @Inject constructor(
    private val bootCounterAppAppDatabase: BootCounterAppAppDatabase
) : BootEventRepository {

    override suspend fun getAllBootEvents(): List<BootEventEntity>? = withContext(Dispatchers.IO) {
        bootCounterAppAppDatabase.bootEventDao().getAll()
            ?.map { bootEventDBEntity -> bootEventDBEntity.toDomain() }
    }

    override suspend fun insertBootEvent(bootEventEntity: BootEventEntity) {
        bootCounterAppAppDatabase.bootEventDao().insert(bootEventDBEntity = bootEventEntity.toDb())
    }

}
