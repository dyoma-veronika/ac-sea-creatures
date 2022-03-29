package ac.seacreature.acseacreatures.datasource.remote.service

import com.google.gson.JsonParseException
import retrofit2.Response
import ac.seacreature.acseacreatures.common.network.LoadingState
import ac.seacreature.acseacreatures.common.network.NetworkErrors
import ac.seacreature.acseacreatures.common.network.RequestState
import ac.seacreature.acseacreatures.data.datasource.remote.api.SeaCreaturesApi
import ac.seacreature.acseacreatures.data.datasource.remote.service.INetworkService
import ac.seacreature.acseacreatures.domain.model.SeaCreatureData
import ac.seacreature.acseacreatures.datasource.remote.mapper.toSeaCreatureData
import java.io.IOException

class NetworkService(private val api: SeaCreaturesApi) : INetworkService {

    override suspend fun getAllData(): RequestState<List<SeaCreatureData>?> {
        val rawRequestState = safeApiCall { api.getCreatures() }
        return RequestState(
            data = rawRequestState.data?.values?.map { it.toSeaCreatureData() },
            loadingState = rawRequestState.loadingState
        )
    }

    override suspend fun getElementById(id: Int): RequestState<SeaCreatureData?> {
        val rawRequestState = safeApiCall { api.getCreatureById(id) }
        return RequestState(
            data = rawRequestState.data?.toSeaCreatureData(),
            loadingState = rawRequestState.loadingState
        )
    }

    private suspend inline fun <T> safeApiCall(
        noinline call: suspend () -> Response<T>
    ): RequestState<T?> {
        try {
            val response = call.invoke()
            return if (response.isSuccessful) {
                val responseBody: T? = response.body()
                if (responseBody != null) {
                    RequestState(
                        data = responseBody,
                        loadingState = LoadingState.Success
                    )
                } else {
                    RequestState(
                        data = null,
                        loadingState = LoadingState.Error(NetworkErrors.NullBodyException)
                    )
                }
            } else {
                val loadingState = when (response.code()) {
                    in 400..499 ->
                        LoadingState.Error(NetworkErrors.ClientException)
                    in 500..526 ->
                        LoadingState.Error(NetworkErrors.ServerException)
                    else -> LoadingState.Error(NetworkErrors.UnknowingError)
                }
                RequestState(
                    data = null,
                    loadingState = loadingState
                )
            }

        } catch (exc: JsonParseException) {
            return RequestState(
                data = null,
                loadingState = LoadingState.Error(NetworkErrors.JsonParseException)
            )
        } catch (exc: IOException) {
            return RequestState(
                data = null,
                loadingState = LoadingState.Error(NetworkErrors.IOException)
            )
        } catch (exc: Exception) {
            return RequestState(
                data = null,
                loadingState = LoadingState.Error(NetworkErrors.UnknowingError)
            )
        }
    }
}
