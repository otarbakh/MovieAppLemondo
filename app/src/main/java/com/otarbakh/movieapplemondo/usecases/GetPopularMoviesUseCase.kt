package com.otarbakh.movieapplemondo.usecases

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

sealed class PopularMoviesResult {
    data class Success(val list: List<MovieDomain>) : PopularMoviesResult()
    data class ErrorGeneral(val error: String) : PopularMoviesResult()
    data class Loading(val isLoading: Boolean) : PopularMoviesResult()
    object InternetError : PopularMoviesResult()
    object Empty : PopularMoviesResult()
}
