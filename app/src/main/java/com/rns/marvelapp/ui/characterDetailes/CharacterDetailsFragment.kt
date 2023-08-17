package com.rns.marvelapp.ui.characterDetailes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.rns.marvelapp.R
import com.rns.marvelapp.databinding.FragmentCharacterDetailsBinding
import com.rns.marvelapp.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import androidx.navigation.fragment.navArgs
import com.rns.marvelapp.ui.characterDetailes.comics.AllComicsFragment
import com.rns.marvelapp.ui.characterDetailes.comics.ComicAdapter
import com.rns.marvelapp.utils.EventObserve

@AndroidEntryPoint
class CharacterDetailsFragment : BaseFragment<FragmentCharacterDetailsBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_character_details
    override val viewModel: CharacterDetailsViewModel by activityViewModels()
    private val navArgs: CharacterDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCharacterDetail(navArgs.characterId)
        viewModel.getComics(navArgs.characterId)

        binding.recyclerView.adapter = ComicAdapter(emptyList(), viewModel)

        viewModel.navigateToSeeMore.observe(viewLifecycleOwner, EventObserve {
            findNavController().navigate(CharacterDetailsFragmentDirections.actionCharacterDetailsFragmentToAllComicsFragment())
        })

    }

}