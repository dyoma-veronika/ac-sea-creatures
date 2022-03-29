package ac.seacreature.acseacreatures.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class NameDto(
    @SerializedName("name-USen")
    val nameUsEn: String,
    @SerializedName("name-EUru")
    val nameEuRu: String
)
