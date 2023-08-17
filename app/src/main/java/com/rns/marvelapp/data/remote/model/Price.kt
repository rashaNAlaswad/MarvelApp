package com.rns.marvelapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("price")
    val price: Double? = null,
    @SerializedName("type")
    val type: String? = null
)