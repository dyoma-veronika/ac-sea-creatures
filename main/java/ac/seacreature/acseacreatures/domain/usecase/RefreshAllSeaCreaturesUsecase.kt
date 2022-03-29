package ac.seacreature.acseacreatures.domain.usecase

import kotlinx.coroutines.flow.Flow
import ac.seacreature.acseacreatures.common.network.LoadingState
import ac.seacreature.acseacreatures.domain.repo.ISeaCreatureRepository

class RefreshAllSeaCreaturesUsecase(private val seaCreatureRepository: ISeaCreatureRepository) {
    operator fun invoke(): Flow<LoadingState> = seaCreatureRepository.updateData()
}
