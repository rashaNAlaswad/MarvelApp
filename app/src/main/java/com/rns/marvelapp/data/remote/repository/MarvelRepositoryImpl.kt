package com.rns.marvelapp.data.remote.repository

import com.rns.marvelapp.data.remote.MarvelService
import com.rns.marvelapp.data.remote.model.Character
import com.rns.marvelapp.data.remote.model.Comics
import com.rns.marvelapp.utils.State
import com.rns.marvelapp.data.remote.model.MarvelResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val api: MarvelService,
) : MarvelRepository {
    override fun getCharacter(): Single<State<MarvelResponse<Character>>> {
        return wrapperWithState(api.getCharacters())
    }

    override fun getCharacterById(characterId: Int): Single<State<MarvelResponse<Character>>> {
        return wrapperWithState(api.getCharacterById(characterId))
    }

    override fun getComicsByCharacterId(characterId: Int): Single<State<MarvelResponse<Comics>>> {
        return wrapperWithState(api.getComicsByCharacterId(characterId))
    }

    private fun <T> wrapperWithState(response: Single<Response<T>>): Single<State<T>> {
        return response.map {
            State.Loading
            if (it.isSuccessful) {
                State.Success(it.body())
            } else {
                State.Error(it.message())
            }
        }

    }
}