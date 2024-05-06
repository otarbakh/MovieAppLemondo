package com.otarbakh.movieapplemondo.usecases

import com.otarbakh.movieapplemondo.data.model.toDomainModel
import com.otarbakh.movieapplemondo.data.repository.IMoviesRepository
import com.otarbakh.movieapplemondo.domain.model.MovieDetailDomain
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetDetailsMovieUseCase @Inject constructor(
    private val iMoviesRepository: IMoviesRepository
) {
    suspend operator fun invoke(
        api_key: String,
        language: String,
        id: String
    ) = iMoviesRepository.getMovieDetail(api_key, language, id).map {
        it.toDomainModel()
    }
}

sealed class GetDetailsMovieResult {
    data class Loading(val isLoading: Boolean) : GetDetailsMovieResult()
    data class Success(val data: MovieDetailDomain) : GetDetailsMovieResult()
    data class Error(val message:String) : GetDetailsMovieResult()
    data class InternetError(val message:String) : GetDetailsMovieResult()
}

