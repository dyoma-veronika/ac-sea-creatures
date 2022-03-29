package ac.seacreature.acseacreatures.datasource.local.db.entity

import androidx.room.ColumnInfo

data class NameEmbedded(
    @ColumnInfo(name = "us_en")
    val nameUsEn: String,
    @ColumnInfo(name = "eu_ru")
    val nameEuRu: String
)
