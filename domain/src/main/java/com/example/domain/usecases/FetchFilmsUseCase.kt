package com.example.domain.usecases

import com.example.domain.models.Response
import com.example.domain.repositories.FilmsRepository
import com.example.domain.utils.Either
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchFilmsUseCase @Inject constructor(
    private val repository: FilmsRepository,
) {

    suspend operator fun invoke(): Flow<Either<String, List<Response>>> = repository.fetchFilms()
}