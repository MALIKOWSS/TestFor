package com.example.domain.usecases

import com.example.domain.repositories.DetailFilmRepository
import javax.inject.Inject

class FetchDetailFilmUseCase @Inject constructor(private val detailFilmRepository: DetailFilmRepository) {

    operator fun invoke(id: String) = detailFilmRepository.fetchDetailFilms(id)
}