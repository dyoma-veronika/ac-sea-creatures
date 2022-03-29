package ac.seacreature.acseacreatures.di

import org.koin.dsl.module
import ac.seacreature.acseacreatures.datasource.local.LocalProvider
import ac.seacreature.acseacreatures.datasource.local.db.SeaCreaturesDatabase

val databaseModule = module {
    single<SeaCreaturesDatabase> { LocalProvider.provideDatabase(get()) }
}
