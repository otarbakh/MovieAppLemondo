package com.otarbakh.movieapplemondo.data.local

import com.otarbakh.movieapplemondo.domain.local.FavoriteMoviesEntity
import com.otarbakh.movieapplemondo.domain.local.FavoriteMoviesEntityDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject



class FavoriteMoviesLocalDataSourceImpl @Inject
constructor(
    val moviesDao:FavoriteMoviesEntityDao
):FavoriteMoviesLocalDataSource{
    override fun getFavoriteMovies(): Flow<List<FavoriteMoviesEntity>> {
        return moviesDao.getAll()
    }

    override fun getFavoriteMovieById(id: Int): Flow<FavoriteMoviesEntity> {
        return moviesDao.getById(id)
    }

    override suspend fun insertFavoriteMovie(favoriteMoviesEntity: FavoriteMoviesEntity) {
        return moviesDao.insert(favoriteMoviesEntity)
    }

    override suspend fun deleteFavoriteMovie(id: Int) {
        return moviesDao.deleteById(id)
    }

}