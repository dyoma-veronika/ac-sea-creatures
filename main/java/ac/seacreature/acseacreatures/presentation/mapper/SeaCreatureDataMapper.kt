package ac.seacreature.acseacreatures.presentation.mapper

import ac.seacreature.acseacreatures.domain.model.SeaCreatureData
import ac.seacreature.acseacreatures.presentation.model.SeaCreatureViewData

fun SeaCreatureData.toSeaCreatureViewData() = SeaCreatureViewData(
    id = id,
    nameEuRu = name.nameEuRu,
    nameUsEn = name.nameUsEn,
    price = price,
    iconUri = iconUri
)