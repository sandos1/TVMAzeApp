package com.sandona.tvmazeapp.domain.repository

import android.util.Log
import com.sandona.tvmazeapp.dataSource.MovieAPIService
import com.sandona.tvmazeapp.domain.model.MovieResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

const val TAG = "MovieRepository"
class MovieRepository @Inject constructor(private val service: MovieAPIService) {

    fun allMovieList(): Flow<Response<List<MovieResponse>>> = flow {
       emit(service.getShowList())
    }
}
