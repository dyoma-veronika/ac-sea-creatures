package ac.seacreature.acseacreatures.domain.repo

import kotlinx.coroutines.flow.Flow
import ac.seacreature.acseacreatures.common.network.LoadingState
import ac.seacreature.acseacreatures.domain.model.SeaCreatureData

interface ISeaCreatureRepository {

    fun updateData(): Flow<LoadingState>

    fun getSeaCreatures(): Flow<List<SeaCreatureData>>

    fun getSeaCreature(id: Int): Flow<SeaCreatureData>
}
