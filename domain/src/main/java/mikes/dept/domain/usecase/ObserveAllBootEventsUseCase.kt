package mikes.dept.domain.usecase

import kotlinx.coroutines.flow.Flow
import mikes.dept.domain.entities.BootEventEntity
import mikes.dept.domain.repository.BootEventRepository
import javax.inject.Inject

class ObserveAllBootEventsUseCase @Inject constructor(
    private val bootEventRepository: BootEventRepository
) {

    operator fun invoke(): Flow<List<BootEventEntity>> = bootEventRepository.observeAllBootEvents()

}
