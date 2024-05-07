package com.otarbakh.movieapplemondo.data.model

import com.otarbakh.movieapplemondo.domain.model.ProductionCompany
import com.otarbakh.movieapplemondo.domain.model.ProductionCompanyDomain

data class ProductionCompany(
    val id: Int,
    val logo_path: String,
    val name: String,
    val origin_country: String
)

fun List<ProductionCompany>.toDomainProductionCompany(): List<ProductionCompanyDomain> {
    return this.map {
        ProductionCompanyDomain(
            id = it.id,
            logo_path = it.logo_path,
            name = it.name,
            origin_country = it.origin_country
        )
    }
}