package com.rns.marvelapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class Next(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null
)