package protorider0.model

import com.google.gson.annotations.SerializedName

data class Rider(
    val rider: String,
    val identidad: String,
    val armor: String,
    val fav: Boolean,
    val serie: String
)