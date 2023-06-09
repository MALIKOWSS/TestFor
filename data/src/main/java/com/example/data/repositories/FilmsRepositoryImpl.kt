package com.example.data.repositories

import com.example.data.BaseRepository
import com.example.data.remote.apiservices.FilmsApiService
import com.example.domain.repositories.FilmsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmsRepositoryImpl @Inject constructor(
    private val filmsApiService: FilmsApiService
) : BaseRepository(), FilmsRepository {

    override suspend fun fetchFilms() = doRequest {
        filmsApiService.fetchFilms().map {
            it
        }
    }
}