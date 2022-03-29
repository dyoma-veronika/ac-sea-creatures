package ac.seacreature.acseacreatures.data.datasource.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ac.seacreature.acseacreatures.datasource.local.db.entity.SeaCreatureEntity

@Dao
interface SeaCreatureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(seaCreatures: List<SeaCreatureEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(seaCreatures: SeaCreatureEntity)

    @Query("SELECT * FROM sea_creatures")
    fun getAll(): Flow<List<SeaCreatureEntity>>

    @Query("SELECT * FROM sea_creatures WHERE id IS (:creatureId) LIMIT 1")
    fun loadById(creatureId: Int): Flow<SeaCreatureEntity>
}
