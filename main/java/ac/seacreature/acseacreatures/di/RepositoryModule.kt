package ac.seacreature.acseacreatures.di

import org.koin.dsl.module
import ac.seacreature.acseacreatures.data.repository.SeaCreatureRepository
import ac.seacreature.acseacreatures.domain.repo.ISeaCreatureRepository

val repositoryModule = module {
    factory<ISeaCreatureRepository> { SeaCreatureRepository(get(), get()) }
}
