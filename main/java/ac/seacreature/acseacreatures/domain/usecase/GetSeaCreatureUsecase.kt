package ac.seacreature.acseacreatures.domain.usecase

import kotlinx.coroutines.flow.Flow
import ac.seacreature.acseacreatures.domain.model.SeaCreatureData
import ac.seacreature.acseacreatures.domain.repo.ISeaCreatureRepository

class GetSeaCreatureUsecase(private val seaCreatureRepository: ISeaCreatureRepository) {
    operator fun invoke(id: Int): Flow<SeaCreatureData> =
        seaCreatureRepository.getSeaCreature(id)
}
