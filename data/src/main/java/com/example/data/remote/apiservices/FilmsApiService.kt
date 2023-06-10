package com.example.data.remote.apiservices

import com.example.data.dtos.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmsApiService {

    @GET("films")
    suspend fun fetchFilms(
        @Query("fields") title: String = "",
        @Query("limit") original_title: Int = 50,
    ): List<ResponseDto>

    @GET("films/{id}")
    suspend fun fetchDetailFilmById(
        @Path("id") id: String,
    ): ResponseDto

}
