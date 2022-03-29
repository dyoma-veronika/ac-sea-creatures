package ac.seacreature.acseacreatures.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class SeaCreatureDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("file-name")
    val fileName: String,
    @SerializedName("name")
    val name: NameDto,
    @SerializedName("speed")
    val speed: String,
    @SerializedName("shadow")
    val shadow: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("catch-phrase")
    val catchPhrase: String,
    @SerializedName("image_uri")
    val imageUri: String,
    @SerializedName("icon_uri")
    val iconUri: String,
    @SerializedName("museum-phrase")
    val museumPhrase: String
)
