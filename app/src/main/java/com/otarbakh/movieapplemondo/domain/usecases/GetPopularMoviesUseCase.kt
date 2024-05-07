package com.otarbakh.movieapplemondo.domain.usecases

import com.otarbakh.movieapplemondo.data.repository.IMoviesRepository
import com.otarbakh.movieapplemondo.domain.MovieDomain
import com.otarbakh.movieapplemondo.domain.toDomainModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val iMoviesRepository: IMoviesRepository
) {
    suspend operator fun invoke(
        api_key: String,
        language: String,
        page: Int
    ) = iMoviesRepository.getPopularMovies(api_key, language, page).map {
        it.results.toDomainModel()
    }
}

