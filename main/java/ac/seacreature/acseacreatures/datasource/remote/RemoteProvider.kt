package ac.seacreature.acseacreatures.datasource.remote

import ac.seacreature.acseacreatures.BuildConfig
import ac.seacreature.acseacreatures.data.datasource.remote.api.SeaCreaturesApi
import ac.seacreature.acseacreatures.data.datasource.remote.service.INetworkService
import ac.seacreature.acseacreatures.datasource.remote.service.NetworkService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RemoteProvider {

    fun provideOkHttp(): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }
        ).build()

    fun provideRetrofit(okHttpClient: OkHttpClient): SeaCreaturesApi = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(SeaCreaturesApi::class.java)

    fun provideNetworkService(api: SeaCreaturesApi): INetworkService = NetworkService(api)
}
