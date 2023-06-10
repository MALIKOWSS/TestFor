package com.example.presentation.ui.fragments.films.detail

import com.example.domain.usecases.FetchDetailFilmUseCase
import com.example.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailFilmsViewModel @Inject constructor(private val fetchDetailFilmUseCase: FetchDetailFilmUseCase)
    : BaseViewModel() {

    fun fetchDetailFilmById(id: String) = fetchDetailFilmUseCase.invoke(id)
}