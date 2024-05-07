package com.otarbakh.movieapplemondo.data.local

import com.otarbakh.movieapplemondo.domain.local.FavoriteMoviesEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteMoviesLocalDataSource {
    fun getFavoriteMovies(): Flow<List<FavoriteMoviesEntity>>
    fun getFavoriteMovieById(id: Int): Flow<FavoriteMoviesEntity>
    suspend fun insertFavoriteMovie(favoriteMoviesEntity: FavoriteMoviesEntity)
    suspend fun deleteFavoriteMovie(id: Int)
}