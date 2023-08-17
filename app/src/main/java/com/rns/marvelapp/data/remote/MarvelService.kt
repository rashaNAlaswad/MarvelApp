package com.rns.marvelapp.data.remote

import com.rns.marvelapp.data.remote.model.Character
import com.rns.marvelapp.data.remote.model.Comics
import com.rns.marvelapp.data.remote.model.MarvelResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {
    @GET("characters")
    fun getCharacters(): Single<Response<MarvelResponse<Character>>>

    @GET("characters/{characterId}")
    fun getCharacterById(@Path("characterId") characterId: Int): Single<Response<MarvelResponse<Character>>>

    @GET("characters/{characterId}/comics")
    fun getComicsByCharacterId(
        @Path("characterId") characterId: Int,
    ): Single<Response<MarvelResponse<Comics>>>
}