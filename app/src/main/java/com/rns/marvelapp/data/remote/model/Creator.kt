package com.rns.marvelapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class Creator(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("role")
    val role: String? = null
)