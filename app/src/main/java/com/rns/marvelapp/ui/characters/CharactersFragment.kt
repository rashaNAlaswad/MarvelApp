package com.rns.marvelapp.ui.characters

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rns.marvelapp.R
import com.rns.marvelapp.databinding.FragmentCharactersBinding
import com.rns.marvelapp.ui.base.BaseFragment
import com.rns.marvelapp.utils.EventObserve
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding>() {
    override val layoutIdFragment: Int
        get() = R.layout.fragment_characters
    override val viewModel: CharacterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = CharacterAdapter(emptyList(), viewModel)

        navigateToCharacterDetails()
    }

    private fun navigateToCharacterDetails() {
        viewModel.characterId.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(
                CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(
                    it
                )
            )
        })
    }
}