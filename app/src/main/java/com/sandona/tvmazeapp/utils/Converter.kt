package com.sandona.tvmazeapp.utils

import com.sandona.tvmazeapp.domain.model.MovieResponse
import com.sandona.tvmazeapp.networkDomain.Movie2NetworkResponse

object Converter {

// converting network model to domain

    fun List<Movie2NetworkResponse>.toMovie(): List<MovieResponse> {
        return map {
            MovieResponse(
                id = it.id,
                imageUrl = it.image?.original,
                name = it.name
            )
        }
    }
}
