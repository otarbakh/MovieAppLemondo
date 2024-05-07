package com.otarbakh.movieapplemondo.domain.usecases

import com.otarbakh.movieapplemondo.data.repository.IMoviesRepository
import com.otarbakh.movieapplemondo.data.database.FavoriteMoviesEntity
import javax.inject.Inject

class InsertFavoriteMovieUseCase @Inject constructor(
    private val repository: IMoviesRepository
) {
    suspend operator fun invoke(favoriteMoviesEntity: FavoriteMoviesEntity) =
        repository.insertFavoriteMovie(favoriteMoviesEntity)
}