package com.otarbakh.movieapplemondo.data.repository


import com.otarbakh.movieapplemondo.domain.model.MoviesDetailResponse
import com.otarbakh.movieapplemondo.domain.PopularsMovieResponse
import com.otarbakh.movieapplemondo.data.database.FavoriteMoviesEntity
import kotlinx.coroutines.flow.Flow


interface IMoviesRepository {
    suspend fun getPopularMovies(
        api_key: String,
        language: String,
        page: Int
    ): Flow<PopularsMovieResponse>

    suspend fun getMovieDetail(
        api_key: String,
        language: String,
        id: String
    ): Flow<MoviesDetailResponse>

    suspend fun searchMovie(
        query: String,
        api_key: String,
        language: String,
    ): Flow<PopularsMovieResponse>

    fun getFavoriteMovies(): Flow<List<FavoriteMoviesEntity>>
    fun getFavoriteMovieById(id: Int): Flow<FavoriteMoviesEntity>
    suspend fun insertFavoriteMovie(favoriteMoviesEntity: FavoriteMoviesEntity)
    suspend fun deleteFavoriteMovie(id: Int)
}

