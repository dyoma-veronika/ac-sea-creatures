package ac.seacreature.acseacreatures.domain.usecase

import kotlinx.coroutines.flow.Flow
import ac.seacreature.acseacreatures.domain.model.SeaCreatureData
import ac.seacreature.acseacreatures.domain.repo.ISeaCreatureRepository

class GetAllSeaCreaturesUsecase(private val seaCreatureRepository: ISeaCreatureRepository) {
    operator fun invoke(): Flow<List<SeaCreatureData>> =
        seaCreatureRepository.getSeaCreatures()
}
