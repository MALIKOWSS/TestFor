package com.example.domain.repositories

import com.example.domain.models.Response
import com.example.domain.utils.Either
import kotlinx.coroutines.flow.Flow

interface FilmsRepository {
    suspend fun fetchFilms(): Flow<Either<String, List<Response>>>
}