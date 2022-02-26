package com.sandona.tvmazeapp.domain.repository

import com.sandona.tvmazeapp.dataSource.MovieAPIService
import com.sandona.tvmazeapp.domain.mapper.MovieMapper
import com.sandona.tvmazeapp.domain.model.MovieResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

const val TAG = "MovieRepository"
class MovieRepository @Inject constructor(
    private val service: MovieAPIService,
    private val movieMapper: MovieMapper
) {

    suspend fun allMovieList(): Flow<List<MovieResponse>> {

        return flow {
            val response = service.getShowList()
            // Log.d(TAG, "service failure ${e.message}")
            if (response.isSuccessful && response.body() != null) {
                val movieList =
                    response.body()!!.map {
                        movieMapper.mapDtoToEntity(it)
                    }

                emit(movieList)
            } else {
                emit(listOf())
            }
        }
    }
}
