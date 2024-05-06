package com.otarbakh.movieapplemondo.data.model

import com.otarbakh.movieapplemondo.domain.model.Genre
import com.otarbakh.movieapplemondo.domain.model.GenreDomain

data class Genre(
    val id: Int,
    val name: String
)
fun List<Genre>.toDomainGenre(): List<GenreDomain> {
    return this.map {
        GenreDomain(
            id = it.id,
            name = it.name
        )
    }
}