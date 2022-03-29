package ac.seacreature.acseacreatures.data.datasource.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ac.seacreature.acseacreatures.datasource.remote.model.SeaCreatureDto

interface SeaCreaturesApi {
    @GET("/v1/sea")
    suspend fun getCreatures(): Response<Map<String, SeaCreatureDto>>

    @GET("/v1/sea/{seaID}")
    suspend fun getCreatureById(@Path("seaID") seaID: Int): Response<SeaCreatureDto>
}
