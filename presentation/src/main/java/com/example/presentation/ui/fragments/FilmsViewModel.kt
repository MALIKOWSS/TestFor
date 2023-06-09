package com.example.presentation.ui.fragments

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Response
import com.example.domain.usecases.FetchFilmsUseCase
import com.example.domain.utils.Either
import com.example.presentation.base.BaseViewModel
import com.example.presentation.models.ResponseUI
import com.example.presentation.models.toDomain
import com.example.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val fetchFilmsUseCase: FetchFilmsUseCase
) : ViewModel() {

    private val _animeState = MutableStateFlow<UIState<List<ResponseUI>>>(UIState.Loading())
    val filmsState get() = _animeState.asStateFlow()

    init {
        fetchFilms()
    }

    private fun fetchFilms() {
        viewModelScope.launch {
            fetchFilmsUseCase().collect {
                when (it) {
                    is Either.Left -> {
                        it.message?.let { error ->
                            _animeState.value = UIState.Error(error)
                        }
                    }
                    is Either.Right -> {
                        it.data?.let {
                            _animeState.value = UIState.Success(it.map { anime ->
                                anime.toUI()
                            })
                        }
                    }
                }
            }
        }
    }
}