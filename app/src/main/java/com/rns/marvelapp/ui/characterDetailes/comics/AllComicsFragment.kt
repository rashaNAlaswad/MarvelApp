package com.rns.marvelapp.ui.characterDetailes.comics

import android.os.Bundle
import android.util.LayoutDirection
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.rns.marvelapp.R
import com.rns.marvelapp.databinding.FragmentAllComicsBinding
import com.rns.marvelapp.ui.base.BaseFragment
import com.rns.marvelapp.ui.characterDetailes.CharacterDetailsFragmentArgs
import com.rns.marvelapp.ui.characterDetailes.CharacterDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllComicsFragment : BaseFragment<FragmentAllComicsBinding>() {
    override val layoutIdFragment: Int
        get() = R.layout.fragment_all_comics
    override val viewModel: CharacterDetailsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = ComicAdapter(emptyList(), viewModel)
    }
}