package com.rns.marvelapp.ui.characters

import com.rns.marvelapp.ui.base.BaseInteractionListener

interface CharacterInteractionListener : BaseInteractionListener{
    fun onItemClicked(id : Int)
}