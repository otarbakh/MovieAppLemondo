package com.otarbakh.movieapplemondo.data.di


import com.otarbakh.movieapplemondo.data.local.FavoriteMoviesLocalDataSourceImpl
import com.otarbakh.movieapplemondo.data.local.FavoriteMoviesLocalDataSource
import com.otarbakh.movieapplemondo.data.remote.IMoviesRemoteDataSource
import com.otarbakh.movieapplemondo.data.remote.IMoviesService
import com.otarbakh.movieapplemondo.data.remote.MoviesRemoteDataSource
import com.otarbakh.movieapplemondo.data.remote.MoviesService
import com.otarbakh.movieapplemondo.data.remote.MoviesServiceImpl
import com.otarbakh.movieapplemondo.data.repository.IMoviesRepository
import com.otarbakh.movieapplemondo.data.repository.MoviesRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MoviesModule {

    @Singleton
    @Binds
    abstract fun provideMovieServices(
        moviesServiceImpl: MoviesServiceImpl
    ): IMoviesService

    @Singleton
    @Binds
    abstract fun provideRemoteDataSource(
        remoteDataSource: MoviesRemoteDataSource
    ): IMoviesRemoteDataSource

    @Singleton
    @Binds
    abstract fun provideMoviesRepository(
        moviesRepositoryImpl: MoviesRepository
    ): IMoviesRepository

    @Singleton
    @Binds
    abstract fun provideMoviesLocalDataSource(
        moviesLocalDataSourceImpl: FavoriteMoviesLocalDataSourceImpl
    ): FavoriteMoviesLocalDataSource
}


@Module
@InstallIn(SingletonComponent::class)
object MoviesModuleObj {

    @Singleton
    @Provides
    fun provideMoviesService(
        retrofit: Retrofit
    ): MoviesService {
        return retrofit.create(MoviesService::class.java)
    }
}

