package com.sandona.tvmazeapp.domain.repository

import com.sandona.tvmazeapp.dataSource.MovieAPIService
import com.sandona.tvmazeapp.networkDomain.Movie2NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

const val TAG = "MovieRepository"
class MovieRepository @Inject constructor(private val service: MovieAPIService) {

    suspend fun allMovieList(): Response<List<Movie2NetworkResponse>> = withContext(Dispatchers.IO) {
        service.getShowList()
    }
}
