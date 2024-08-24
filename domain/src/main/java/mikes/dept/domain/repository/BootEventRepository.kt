package mikes.dept.domain.repository

import kotlinx.coroutines.flow.Flow
import mikes.dept.domain.entities.BootEventEntity

interface BootEventRepository {

    fun observeAllBootEvents(): Flow<List<BootEventEntity>>

    suspend fun insertBootEvent(bootEventEntity: BootEventEntity)

}
