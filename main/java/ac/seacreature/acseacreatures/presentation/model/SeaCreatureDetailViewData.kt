package ac.seacreature.acseacreatures.presentation.model

data class SeaCreatureDetailViewData(
    val id: Int,
    val nameEuRu: String,
    val nameUsEn: String,
    val speed: String,
    val shadow: String,
    val price: Int,
    val catchPhrase: String,
    val museumPhrase: String,
    val imageUri: String
)
