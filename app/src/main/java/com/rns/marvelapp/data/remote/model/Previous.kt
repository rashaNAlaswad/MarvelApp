package com.rns.marvelapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class Previous(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null
)