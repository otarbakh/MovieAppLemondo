package com.otarbakh.movieapplemondo.data.model

import com.otarbakh.movieapplemondo.BuildConfig
import com.otarbakh.movieapplemondo.domain.model.MovieDetailDomain
import com.otarbakh.movieapplemondo.domain.model.MoviesDetailResponse

data class MoviesResponse(
    val adult: Boolean,
    val backdrop_path: String,
    val belongs_to_collection: BelongsToCollection,
    val budget: Int,
    val genres: List<Genre>,
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguage>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

fun MoviesDetailResponse.toDomainModel(): MovieDetailDomain {
    return MovieDetailDomain(
        adult = this.adult,
        backdrop_path = BuildConfig.IMAGE_URL + this.backdrop_path,
        belongs_to_collection = this.belongs_to_collection?.toDomainBelongsCollection(),
        budget = this?.budget,
        genres = this.genres?.toDomainGenre(),
        homepage = this.homepage,
        id = this.id,
        imdb_id = this.imdb_id,
        original_language = this.original_language,
        original_title = this.original_title,
        overview = this.overview,
        popularity = this.popularity,
        poster_path = BuildConfig.IMAGE_URL + this.poster_path,
        production_companies = this.production_companies?.toDomainProductionCompany(),
        production_countries = this.production_countries?.toDomainProductionCountry(),
        release_date = this.release_date,
        revenue = this.revenue,
        runtime = this.runtime,
        runtimeWithMinutes = "${this.runtime} minutes",
        spoken_languages = this.spoken_languages?.toDomainSpokenLan(),
        status = this.status,
        tagline = this.tagline,
        title = this.title,
        video = this.video,
        vote_average = this.vote_average,
        vote_count = this.vote_count
    )
}