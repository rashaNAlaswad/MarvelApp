package com.rns.marvelapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class StoryItem(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("type")
    val type: String? = null
)