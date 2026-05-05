package fi.developer.designpattern_android.domain.model

import com.google.gson.annotations.SerializedName

data class CoinsResponseItem(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)