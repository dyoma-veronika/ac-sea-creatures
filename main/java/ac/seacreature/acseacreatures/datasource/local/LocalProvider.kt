package ac.seacreature.acseacreatures.datasource.local

import android.content.Context
import androidx.room.Room
import ac.seacreature.acseacreatures.datasource.local.db.SeaCreaturesDatabase

object LocalProvider {

    //region keys
    private const val DB_NAME = "sea-creatures"
    //endregion

    fun provideDatabase(applicationContext: Context): SeaCreaturesDatabase =
        Room.databaseBuilder(
            applicationContext,
            SeaCreaturesDatabase::class.java, DB_NAME
        ).build()
}
