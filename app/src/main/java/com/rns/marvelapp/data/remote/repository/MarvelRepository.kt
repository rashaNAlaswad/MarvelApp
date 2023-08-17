package com.rns.marvelapp.data.remote.repository

import com.rns.marvelapp.data.remote.model.Character
import com.rns.marvelapp.data.remote.model.Comics
import com.rns.marvelapp.utils.State
import com.rns.marvelapp.data.remote.model.MarvelResponse
import io.reactivex.rxjava3.core.Single

interface MarvelRepository {
    fun getCharacter(): Single<State<MarvelResponse<Character>>>
    fun getCharacterById(characterId: Int): Single<State<MarvelResponse<Character>>>
    fun getComicsByCharacterId(characterId: Int): Single<State<MarvelResponse<Comics>>>
}