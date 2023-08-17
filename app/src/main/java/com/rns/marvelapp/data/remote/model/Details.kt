package com.rns.marvelapp.data.remote.model

import com.google.gson.annotations.SerializedName
import com.rns.marvelapp.data.remote.model.Summary

data class Details(
    @SerializedName("available")
    val available: Int? = null,
    @SerializedName("collectionURI")
    val collectionURI: String? = null,
    @SerializedName("items")
    val items: List<Summary>? = null,
    @SerializedName("returned")
    val returned: Int? = null
)