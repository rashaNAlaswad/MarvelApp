package com.rns.marvelapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("extension")
    val extension: String? = null,
    @SerializedName("path")
    val path: String? = null
){
    fun loadImage() = "$path.$extension"
}