package com.otarbakh.movieapplemondo.data.di

import com.otarbakh.movieapplemondo.data.remote.MoviesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesModule {
    @Singleton
    @Provides
    fun provideMoviesService(
        retrofit: Retrofit
    ): MoviesService {
        return retrofit.create(MoviesService::class.java)
    }

}