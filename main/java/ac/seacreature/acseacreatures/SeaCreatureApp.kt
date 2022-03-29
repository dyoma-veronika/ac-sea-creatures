package ac.seacreature.acseacreatures

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ac.seacreature.acseacreatures.di.*
import timber.log.Timber

class SeaCreatureApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger()
            androidContext(this@SeaCreatureApp)
            modules(
                networkModule,
                viewModelModule,
                usecaseModule,
                repositoryModule,
                databaseModule
            )
        }
    }
}
