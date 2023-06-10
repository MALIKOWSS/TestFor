package com.example.data.repositories


import com.example.data.base.BaseRepository
import com.example.data.dtos.toDomain
import com.example.data.remote.apiservices.FilmsApiService
import com.example.domain.models.Response
import com.example.domain.repositories.DetailFilmRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DetailFilmRepositoryImpl @Inject constructor(private val service: FilmsApiService) :
    BaseRepository(),
    DetailFilmRepository {

    override fun fetchDetailFilms(id: String): Flow<Resource<Response>> = doRequestForDetail {
        service.fetchDetailFilmById(id).toDomain()
    }
}