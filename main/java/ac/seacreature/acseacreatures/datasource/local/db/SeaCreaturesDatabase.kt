package ac.seacreature.acseacreatures.datasource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ac.seacreature.acseacreatures.data.datasource.local.db.dao.SeaCreatureDao
import ac.seacreature.acseacreatures.datasource.local.db.entity.SeaCreatureEntity

@Database(entities = [SeaCreatureEntity::class], version = 1)
abstract class SeaCreaturesDatabase : RoomDatabase() {
    abstract fun seaCreatureDao(): SeaCreatureDao
}
