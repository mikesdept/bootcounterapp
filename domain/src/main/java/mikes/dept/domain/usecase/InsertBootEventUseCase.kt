package mikes.dept.domain.usecase

import mikes.dept.domain.entities.BootEventEntity
import mikes.dept.domain.repository.BootEventRepository
import javax.inject.Inject

class InsertBootEventUseCase @Inject constructor(
    private val bootEventRepository: BootEventRepository
) {

    suspend operator fun invoke(bootEventEntity: BootEventEntity) {
        bootEventRepository.insertBootEvent(bootEventEntity)
    }

}
