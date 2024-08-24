package mikes.dept.domain.usecase

import mikes.dept.domain.entities.BootEventEntity
import mikes.dept.domain.repository.BootEventRepository
import javax.inject.Inject

class GetAllBootEventsUseCase @Inject constructor(
    private val bootEventRepository: BootEventRepository
) {

    suspend operator fun invoke(): List<BootEventEntity>? = bootEventRepository.getAllBootEvents()

}
