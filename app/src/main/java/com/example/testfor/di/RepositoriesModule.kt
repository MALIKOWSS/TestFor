package com.example.testfor.di

import com.example.data.repositories.DetailFilmRepositoryImpl
import com.example.data.repositories.FilmsRepositoryImpl
import com.example.domain.repositories.DetailFilmRepository
import com.example.domain.repositories.FilmsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun bindFilmsRepository(filmsRepositoryImpl: FilmsRepositoryImpl): FilmsRepository

    @Binds
    fun bindDetailFilmsRepository(detailFilmRepositoryImpl: DetailFilmRepositoryImpl): DetailFilmRepository
}