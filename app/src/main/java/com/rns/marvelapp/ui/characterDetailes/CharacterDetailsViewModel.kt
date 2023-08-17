package com.rns.marvelapp.ui.characterDetailes

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rns.marvelapp.data.remote.model.Character
import com.rns.marvelapp.data.remote.model.Comics
import com.rns.marvelapp.data.remote.repository.MarvelRepositoryImpl
import com.rns.marvelapp.ui.base.BaseViewModel
import com.rns.marvelapp.ui.characterDetailes.comics.ComicInteractionListener
import com.rns.marvelapp.utils.Event
import com.rns.marvelapp.utils.State
import com.rns.marvelapp.data.remote.model.MarvelResponse
import com.rns.marvelapp.utils.addTo
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(private val repository: MarvelRepositoryImpl) :
    BaseViewModel(), ComicInteractionListener {

    private val _characterDetail = MutableLiveData<State<MarvelResponse<Character>>>()
    val characterDetail: LiveData<State<MarvelResponse<Character>>> get() = _characterDetail

    private var _comics = MutableLiveData<State<MarvelResponse<Comics>>>()
    val comics: LiveData<State<MarvelResponse<Comics>>> get() = _comics

    private var _navigateToSeeMore = MutableLiveData<Event<Boolean>>()
    val navigateToSeeMore: LiveData<Event<Boolean>> get() = _navigateToSeeMore

    @SuppressLint("CheckResult")
    fun getCharacterDetail(characterId: Int) {
        _characterDetail.postValue(State.Loading)
        repository.getCharacterById(characterId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onCharacterSuccess, ::onCharacterFailure).addTo(compositeDisposable)
    }

    private fun onCharacterSuccess(data: State<MarvelResponse<Character>>) {
        State.Success(data.toData())
        _characterDetail.postValue(data)
    }

    private fun onCharacterFailure(message: Throwable) {
        _characterDetail.postValue(State.Error(message.message.toString()))
    }

    @SuppressLint("CheckResult")
    fun getComics(characterId: Int) {
        _comics.postValue(State.Loading)
        repository.getComicsByCharacterId(characterId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onComicsSuccess, ::onComicsFailure).addTo(compositeDisposable)
    }

    private fun onComicsSuccess(data: State<MarvelResponse<Comics>>) {
        State.Success(data.toData())
        _comics.postValue(data)
    }

    private fun onComicsFailure(message: Throwable) {
        _comics.postValue(State.Error(message.message.toString()))
    }

    override fun onSeeMoreClicked() {
        _navigateToSeeMore.postValue(Event(true))
    }
}