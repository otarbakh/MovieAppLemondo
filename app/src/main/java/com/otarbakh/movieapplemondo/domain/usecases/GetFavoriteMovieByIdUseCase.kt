package com.otarbakh.movieapplemondo.domain.usecases

import com.otarbakh.movieapplemondo.data.repository.IMoviesRepository
import javax.inject.Inject

class GetFavoriteMovieByIdUseCase @Inject constructor(
    private val repository: IMoviesRepository
) {
    operator fun invoke(id: Int) = repository.getFavoriteMovieById(id)
}