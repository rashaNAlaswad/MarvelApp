package com.rns.marvelapp.data.remote.model

import com.google.gson.annotations.SerializedName
import com.rns.marvelapp.data.remote.model.StoryItem

data class Stories(
    @SerializedName("available")
    val available: Int? = null,
    @SerializedName("collectionURI")
    val collectionURI: String? = null,
    @SerializedName("items")
    val items: List<StoryItem>? = null,
    @SerializedName("returned")
    val returned: Int? = null
)