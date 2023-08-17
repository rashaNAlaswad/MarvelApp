package com.rns.marvelapp.ui.characters

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rns.marvelapp.data.remote.model.Character
import com.rns.marvelapp.data.remote.repository.MarvelRepositoryImpl
import com.rns.marvelapp.ui.base.BaseViewModel
import com.rns.marvelapp.utils.Event
import com.rns.marvelapp.utils.State
import com.rns.marvelapp.utils.addTo
import com.rns.marvelapp.data.remote.model.MarvelResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: MarvelRepositoryImpl) :
    BaseViewModel(), CharacterInteractionListener {
    private var _characters = MutableLiveData<State<MarvelResponse<Character>>>()
    val characters: LiveData<State<MarvelResponse<Character>>> get() = _characters

    private var _characterId = MutableLiveData<Event<Int>>()
    val characterId: LiveData<Event<Int>> get() = _characterId

    init {
        getAllCharacters()
    }

    @SuppressLint("CheckResult")
    private fun getAllCharacters() {
        _characters.postValue(State.Loading)
        repository.getCharacter()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onFailure).addTo(compositeDisposable)
    }

    private fun onSuccess(data: State<MarvelResponse<Character>>) {
        State.Success(data.toData())
        _characters.postValue(data)
    }

    private fun onFailure(message: Throwable) {
        _characters.postValue(State.Error(message.message.toString()))
    }

    override fun onItemClicked(id: Int) {
        _characterId.postValue(Event(id))
    }
}