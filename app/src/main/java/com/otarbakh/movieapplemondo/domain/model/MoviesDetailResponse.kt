package com.otarbakh.movieapplemondo.domain.model


data class MoviesDetailResponse(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val belongs_to_collection: BelongsToCollection? = null,
    val budget: Int? = null,
    val genres: List<Genre>? = null,
    val homepage: String? = null,
    val id: Int? = null,
    val imdb_id: String? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val production_companies: List<ProductionCompany>? = null,
    val production_countries: List<ProductionCountry>? = null,
    val release_date: String? = null,
    val revenue: Int? = null,
    val runtime: Int? = null,
    val spoken_languages: List<SpokenLanguage>? = null,
    val status: String? = null,
    val tagline: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)

data class MovieDetailDomain(
    val adult: Boolean? = null,
    val backdrop_path: String? = null,
    val belongs_to_collection: BelongsToCollectionDomain? = null,
    val budget: Int? = null,
    val genres: List<GenreDomain>? = null,
    val homepage: String? = null,
    val id: Int? = null,
    val imdb_id: String? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val overview: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val production_companies: List<ProductionCompanyDomain>? = null,
    val production_countries: List<ProductionCountryDomain>? = null,
    val release_date: String? = null,
    val revenue: Int? = null,
    val runtime: Int? = null,
    val runtimeWithMinutes: String? = null,
    val spoken_languages: List<SpokenLanguageDomain>? = null,
    val status: String? = null,
    val tagline: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val vote_average: Double? = null,
    val vote_count: Int? = null
)

data class BelongsToCollectionDomain(
    val backdrop_path: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val poster_path: String? = null,
)

data class GenreDomain(
    val id: Int? = null,
    val name: String? = null,
)

data class ProductionCompanyDomain(
    val id: Int? = null,
    val logo_path: String? = null,
    val name: String? = null,
    val origin_country: String? = null,
)

data class ProductionCountryDomain(
    val iso_3166_1: String? = null,
    val name: String? = null,
)

data class SpokenLanguageDomain(
    val english_name: String? = null,
    val iso_639_1: String? = null,
    val name: String? = null,
)



























