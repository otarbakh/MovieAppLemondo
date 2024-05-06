package com.otarbakh.movieapplemondo.data.model

import com.otarbakh.movieapplemondo.domain.model.BelongsToCollection
import com.otarbakh.movieapplemondo.domain.model.BelongsToCollectionDomain

data class BelongsToCollection(
    val backdrop_path: String,
    val id: Int,
    val name: String,
    val poster_path: String
)

fun BelongsToCollection.toDomainBelongsCollection(): BelongsToCollectionDomain {
    return BelongsToCollectionDomain(
        backdrop_path = this.backdrop_path,
        id = this.id,
        name = this.name,
        poster_path = this.poster_path
    )
}