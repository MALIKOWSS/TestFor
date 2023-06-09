package com.example.presentation.ui.fragments

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentFilmsBinding
import com.example.presentation.state.UIState
import com.example.presentation.ui.adapters.FilmsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FilmsFragment : BaseFragment<FragmentFilmsBinding, FilmsViewModel>(R.layout.fragment_films) {

    override val binding by viewBinding(FragmentFilmsBinding::bind)
    override val viewModel: FilmsViewModel by viewModels()
    private val filmsAdapter = FilmsAdapter()
    override fun initialize() {
        binding.recyclerView.adapter = filmsAdapter
    }

    override fun setupObserves() {
        subscribeToFetchFilms()
    }

    private fun subscribeToFetchFilms() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.filmsState.collect {
                    when (it) {
                        is UIState.Error -> {
                        }
                        is UIState.Loading -> {
                        }
                        is UIState.Success -> {
                            filmsAdapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }
}