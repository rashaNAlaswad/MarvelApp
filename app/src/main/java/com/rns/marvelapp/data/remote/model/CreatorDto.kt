package com.rns.marvelapp.data.remote.model

import com.google.gson.annotations.SerializedName
import com.rns.marvelapp.data.remote.model.Details
import com.rns.marvelapp.data.remote.model.Stories
import com.rns.marvelapp.data.remote.model.Thumbnail
import com.rns.marvelapp.data.remote.model.Url

data class CreatorDto(
    @SerializedName("comics")
    val comics: Details? = null,
    @SerializedName("events")
    val events: Details? = null,
    @SerializedName("firstName")
    val firstName: String? = null,
    @SerializedName("fullName")
    val name: String ?= null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("middleName")
    val middleName: String? = null,
    @SerializedName("modified")
    val modified: String? =null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: Details? = null,
    @SerializedName("stories")
    val stories: Stories? = null,
    @SerializedName("suffix")
    val suffix: String? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("urls")
    val urls: List<Url>? = null
)