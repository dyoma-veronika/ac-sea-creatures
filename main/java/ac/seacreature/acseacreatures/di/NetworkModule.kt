package ac.seacreature.acseacreatures.di

import okhttp3.OkHttpClient
import org.koin.dsl.module
import ac.seacreature.acseacreatures.data.datasource.remote.api.SeaCreaturesApi
import ac.seacreature.acseacreatures.data.datasource.remote.service.INetworkService
import ac.seacreature.acseacreatures.datasource.remote.RemoteProvider

val networkModule = module {
    single<OkHttpClient> { RemoteProvider.provideOkHttp() }
    single<SeaCreaturesApi> { RemoteProvider.provideRetrofit(get()) }
    single<INetworkService> { RemoteProvider.provideNetworkService(get()) }
}
