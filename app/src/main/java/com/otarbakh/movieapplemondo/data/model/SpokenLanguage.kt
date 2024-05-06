package com.otarbakh.movieapplemondo.data.model

import com.otarbakh.movieapplemondo.domain.model.SpokenLanguage
import com.otarbakh.movieapplemondo.domain.model.SpokenLanguageDomain

data class SpokenLanguage(
    val english_name: String,
    val iso_639_1: String,
    val name: String
)

fun List<SpokenLanguage>.toDomainSpokenLan(): List<SpokenLanguageDomain> {
    return this.map {
        SpokenLanguageDomain(
            english_name = it.english_name,
            iso_639_1 = it.iso_639_1,
            name = it.name
        )
    }
}