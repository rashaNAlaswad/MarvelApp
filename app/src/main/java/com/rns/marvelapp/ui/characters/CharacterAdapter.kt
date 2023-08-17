package com.rns.marvelapp.ui.characters

import com.rns.marvelapp.R
import com.rns.marvelapp.data.remote.model.Character
import com.rns.marvelapp.ui.base.BaseAdapter


class CharacterAdapter(items: List<Character>, listener: CharacterInteractionListener) :
    BaseAdapter<Character>(_items = items, _listener = listener) {

    override val layoutId: Int
        get() = R.layout.item_character
}