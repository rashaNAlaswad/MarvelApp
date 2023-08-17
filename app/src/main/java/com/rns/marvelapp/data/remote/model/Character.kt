package com.rns.marvelapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("comics")
    val comics: Details? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("events")
    val events: Details? = null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("modified")
    val modified: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: Details? = null,
    @SerializedName("stories")
    val stories: Stories? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("urls")
    val urls: List<Url>? = null
)