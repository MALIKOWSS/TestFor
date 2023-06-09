package com.example.data.dtos

import com.example.domain.models.Response
import com.google.gson.annotations.SerializedName

data class ResponseDto(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("original_title")
    val originalTitle: String = "",
    @SerializedName("director")
    val director: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("vehicles")
    val vehicles: List<String>?,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("rt_score")
    val rtScore: String = "",
    @SerializedName("people")
    val people: List<String>?,
    @SerializedName("url")
    val url: String = "",
    @SerializedName("release_date")
    val releaseDate: String = "",
    @SerializedName("species")
    val species: List<String>?,
    @SerializedName("original_title_romanised")
    val originalTitleRomanised: String = "",
    @SerializedName("producer")
    val producer: String = "",
    @SerializedName("running_time")
    val runningTime: String = "",
    @SerializedName("locations")
    val locations: List<String>?,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("movie_banner")
    val movieBanner: String = "",
)

fun ResponseDto.toDomain(): Response = Response(
    image,
    originalTitle,
    director,
    description,
    vehicles,
    title,
    rtScore,
    people,
    url,
    releaseDate,
    species,
    originalTitleRomanised,
    producer,
    runningTime,
    locations,
    id,
    movieBanner
)