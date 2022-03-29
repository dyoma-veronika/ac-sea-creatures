package ac.seacreature.acseacreatures.data.datasource.remote.service

import ac.seacreature.acseacreatures.common.network.RequestState
import ac.seacreature.acseacreatures.domain.model.SeaCreatureData

interface INetworkService {
    suspend fun getAllData(): RequestState<List<SeaCreatureData>?>
    suspend fun getElementById(id: Int): RequestState<SeaCreatureData?>
}
