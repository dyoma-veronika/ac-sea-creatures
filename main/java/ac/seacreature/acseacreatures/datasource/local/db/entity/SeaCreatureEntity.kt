package ac.seacreature.acseacreatures.datasource.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sea_creatures")
data class SeaCreatureEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "file_name")
    val fileName: String,
    @Embedded(prefix = "name_")
    val name: NameEmbedded,
    @ColumnInfo(name = "speed")
    val speed: String,
    @ColumnInfo(name = "shadow")
    val shadow: String,
    @ColumnInfo(name = "price")
    val price: Int,
    @ColumnInfo(name = "catch_phrase")
    val catchPhrase: String,
    @ColumnInfo(name = "image_uri")
    val imageUri: String,
    @ColumnInfo(name = "icon_uri")
    val iconUri: String,
    @ColumnInfo(name = "museum_phrase")
    val museumPhrase: String
)
