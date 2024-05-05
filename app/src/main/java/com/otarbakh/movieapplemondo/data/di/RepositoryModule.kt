package com.otarbakh.movieapplemondo.data.di


import com.otarbakh.movieapplemondo.data.local.FavoriteMoviesLocalDataSourceImpl
import com.otarbakh.movieapplemondo.data.local.IFavoriteMoviesLocalDataSource
import com.otarbakh.movieapplemondo.data.remote.IMoviesRemoteDataSource
import com.otarbakh.movieapplemondo.data.remote.IMoviesService
import com.otarbakh.movieapplemondo.data.remote.MoviesRemoteDataSource
import com.otarbakh.movieapplemondo.data.remote.MoviesServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


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
        moviesRepositoryImpl: MoviesModule
    ): MoviesModule


    //Local

    @Singleton
    @Binds
    abstract fun provideMoviesLocalDataSource(
        moviesLocalDataSourceImpl: FavoriteMoviesLocalDataSourceImpl
    ): IFavoriteMoviesLocalDataSource

}



