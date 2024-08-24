package mikes.dept.domain.repository

import mikes.dept.domain.entities.BootEventEntity

interface BootEventRepository {

    suspend fun getAllBootEvents(): List<BootEventEntity>?

    suspend fun insertBootEvent(bootEventEntity: BootEventEntity)

}
