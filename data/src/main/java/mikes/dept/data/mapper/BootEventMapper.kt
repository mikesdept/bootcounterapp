package mikes.dept.data.mapper

import mikes.dept.data.database.entities.BootEventDBEntity
import mikes.dept.domain.entities.BootEventEntity

fun BootEventEntity.toDb(): BootEventDBEntity = BootEventDBEntity(timestamp = timestamp)

fun BootEventDBEntity.toDomain(): BootEventEntity = BootEventEntity(timestamp = timestamp)
