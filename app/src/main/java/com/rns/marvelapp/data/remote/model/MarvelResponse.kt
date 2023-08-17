package com.rns.marvelapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class MarvelResponse<T>(
    @SerializedName("attributionHTML")
    val attributionHTML: String? = null,
    @SerializedName("attributionText")
    val attributionText: String? = null,
    @SerializedName("code")
    val code: Int? = null,
    @SerializedName("copyright")
    val copyright: String? = null,
    @SerializedName("data")
    val data: Data<T>? = null,
    @SerializedName("etag")
    val etag: String? = null,
    @SerializedName("status")
    val status: String? = null
)