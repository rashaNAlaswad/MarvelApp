package com.rns.marvelapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class Creators(
    @SerializedName("available")
    val available: Int? = null,
    @SerializedName("collectionURI")
    val collectionURI: String? = null,
    @SerializedName("items")
    val items: List<Creator>? = null,
    @SerializedName("returned")
    val returned: Int? = null
)