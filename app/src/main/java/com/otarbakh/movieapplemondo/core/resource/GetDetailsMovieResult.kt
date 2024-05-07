package com.otarbakh.movieapplemondo.core.resource

import com.otarbakh.movieapplemondo.domain.model.MovieDetailDomain

sealed class GetDetailsMovieResult {
    data class Loading(val isLoading: Boolean) : GetDetailsMovieResult()
    data class Success(val data: MovieDetailDomain) : GetDetailsMovieResult()
    data class Error(val message:String) : GetDetailsMovieResult()
    data class InternetError(val message:String) : GetDetailsMovieResult()
}