package ac.seacreature.acseacreatures.datasource.local.mapper

import ac.seacreature.acseacreatures.datasource.local.db.entity.NameEmbedded
import ac.seacreature.acseacreatures.datasource.local.db.entity.SeaCreatureEntity
import ac.seacreature.acseacreatures.domain.model.NameData
import ac.seacreature.acseacreatures.domain.model.SeaCreatureData

fun SeaCreatureEntity.toSeaCreatureData() = SeaCreatureData(
    id = id,
    fileName = fileName,
    name = name.toNameData(),
    speed = speed,
    shadow = shadow,
    price = price,
    catchPhrase = catchPhrase,
    imageUri = imageUri,
    iconUri = iconUri,
    museumPhrase = museumPhrase
)

private fun NameEmbedded.toNameData() = NameData(
    nameEuRu = nameEuRu,
    nameUsEn = nameUsEn
)

fun SeaCreatureData.toSeaCreatureEntity() = SeaCreatureEntity(
    id = id,
    fileName = fileName,
    name = name.toNameEntity(),
    speed = speed,
    shadow = shadow,
    price = price,
    catchPhrase = catchPhrase,
    imageUri = imageUri,
    iconUri = iconUri,
    museumPhrase = museumPhrase
)

private fun NameData.toNameEntity() = NameEmbedded(
    nameEuRu = nameEuRu,
    nameUsEn = nameUsEn
)
