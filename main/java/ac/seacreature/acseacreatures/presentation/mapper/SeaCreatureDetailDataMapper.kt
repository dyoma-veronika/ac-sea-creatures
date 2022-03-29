package ac.seacreature.acseacreatures.presentation.mapper

import ac.seacreature.acseacreatures.domain.model.SeaCreatureData
import ac.seacreature.acseacreatures.presentation.model.SeaCreatureDetailViewData

fun SeaCreatureData.toSeaCreatureDetailViewData() = SeaCreatureDetailViewData(
    id = id,
    nameEuRu = name.nameEuRu,
    nameUsEn = name.nameUsEn,
    speed = speed,
    shadow = shadow,
    price = price,
    catchPhrase = catchPhrase,
    museumPhrase = museumPhrase,
    imageUri = imageUri
)
