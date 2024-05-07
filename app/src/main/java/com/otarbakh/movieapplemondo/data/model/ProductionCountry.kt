package com.otarbakh.movieapplemondo.data.model

import com.otarbakh.movieapplemondo.domain.model.ProductionCountry
import com.otarbakh.movieapplemondo.domain.model.ProductionCountryDomain

data class ProductionCountry(
    val iso_3166_1: String,
    val name: String
)

fun List<ProductionCountry>.toDomainProductionCountry(): List<ProductionCountryDomain> {
    return this.map {
        ProductionCountryDomain(
            iso_3166_1 = it.iso_3166_1,
            name = it.name
        )
    }
}