package com.rns.marvelapp.ui.characterDetailes.comics

import com.rns.marvelapp.R
import com.rns.marvelapp.ui.base.BaseAdapter
import com.rns.marvelapp.data.remote.model.Comics

class ComicAdapter(items: List<Comics>, listener: ComicInteractionListener) :
    BaseAdapter<Comics>(_items = items, _listener = listener) {

    override val layoutId: Int
        get() = R.layout.item_comic
}