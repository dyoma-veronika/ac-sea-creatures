package ac.seacreature.acseacreatures.domain.model

data class SeaCreatureData(
    val id: Int,
    val fileName: String,
    val name: NameData,
    val speed: String,
    val shadow: String,
    val price: Int,
    val catchPhrase: String,
    val imageUri: String,
    val iconUri: String,
    val museumPhrase: String
)
