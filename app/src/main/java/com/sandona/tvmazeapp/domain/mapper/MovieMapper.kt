package com.sandona.tvmazeapp.domain.mapper

import com.sandona.tvmazeapp.domain.model.MovieResponse
import com.sandona.tvmazeapp.networkDomain.Movie2NetworkResponse
import javax.inject.Inject

class MovieMapper @Inject constructor() : BaseMapper<Movie2NetworkResponse, MovieResponse> {
    override fun mapDtoToEntity(dataResponse: Movie2NetworkResponse): MovieResponse {
        return MovieResponse(
            id = dataResponse.id,
            imageUrl = dataResponse.image?.original,
            name = dataResponse.name,
            language = dataResponse.language,
            type = dataResponse.type
        )
    }
}
