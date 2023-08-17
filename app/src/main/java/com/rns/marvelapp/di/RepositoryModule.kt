package com.rns.marvelapp.di

import com.rns.marvelapp.data.remote.MarvelService
import com.rns.marvelapp.data.remote.repository.MarvelRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideRepository(
        api: MarvelService,
    ) = MarvelRepositoryImpl(api)
}