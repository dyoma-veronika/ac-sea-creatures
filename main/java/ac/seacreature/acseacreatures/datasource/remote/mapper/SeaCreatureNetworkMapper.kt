package ac.seacreature.acseacreatures.datasource.remote.mapper

import ac.seacreature.acseacreatures.datasource.remote.model.NameDto
import ac.seacreature.acseacreatures.datasource.remote.model.SeaCreatureDto
import ac.seacreature.acseacreatures.domain.model.NameData
import ac.seacreature.acseacreatures.domain.model.SeaCreatureData

fun SeaCreatureDto.toSeaCreatureData() = SeaCreatureData(
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

private fun NameDto.toNameData() = NameData(
    nameEuRu = nameEuRu,
    nameUsEn = nameUsEn
)
