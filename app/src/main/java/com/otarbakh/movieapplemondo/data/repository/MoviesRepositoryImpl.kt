package com.otarbakh.movieapplemondo.data.repository

import com.otarbakh.movieapplemondo.data.local.FavoriteMoviesLocalDataSource
import com.otarbakh.movieapplemondo.data.remote.IMoviesRemoteDataSource
import com.otarbakh.movieapplemondo.domain.PopularsMovieResponse
import com.otarbakh.movieapplemondo.data.database.FavoriteMoviesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val remote: IMoviesRemoteDataSource,
    private val local: FavoriteMoviesLocalDataSource
) : IMoviesRepository {

    override suspend fun getPopularMovies(
        api_key: String,
        language: String,
        page: Int
    ) = remote.getPopularMovies(api_key, language, page)

    override suspend fun getMovieDetail(
        api_key: String,
        language: String,
        id: String
    ) = remote.getMovieDetail(api_key, language, id)

    override suspend fun searchMovie(
        query: String,
        api_key: String,
        language: String
    ): Flow<PopularsMovieResponse> {
        return remote.searchMovie(query, api_key, language)
    }

    override fun getFavoriteMovies(): Flow<List<FavoriteMoviesEntity>> {
        return local.getFavoriteMovies()
    }

    override fun getFavoriteMovieById(id: Int): Flow<FavoriteMoviesEntity> {
        return local.getFavoriteMovieById(id)
    }

    override suspend fun insertFavoriteMovie(favoriteMoviesEntity: FavoriteMoviesEntity) {
        local.insertFavoriteMovie(favoriteMoviesEntity)
    }

    override suspend fun deleteFavoriteMovie(id: Int) {
        local.deleteFavoriteMovie(id)
    }
}