package ac.seacreature.acseacreatures.di

import org.koin.dsl.module
import ac.seacreature.acseacreatures.domain.usecase.*

val usecaseModule = module {
    factory<GetAllSeaCreaturesUsecase> { GetAllSeaCreaturesUsecase(get()) }
    factory<RefreshAllSeaCreaturesUsecase> { RefreshAllSeaCreaturesUsecase(get()) }
    factory<GetSeaCreatureUsecase> { GetSeaCreatureUsecase(get()) }
}
