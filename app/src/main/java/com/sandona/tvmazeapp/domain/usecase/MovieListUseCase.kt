package com.sandona.tvmazeapp.domain.usecase

import android.util.Log
import com.sandona.tvmazeapp.domain.model.MovieResponse
import com.sandona.tvmazeapp.domain.repository.MovieRepository
import com.sandona.tvmazeapp.domain.repository.TAG
import com.sandona.tvmazeapp.utils.Converter.toMovie
import javax.inject.Inject

class MovieListUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(): List<MovieResponse>? {
        val response = repository.allMovieList()

        return if (response.isSuccessful) {
            response.body()?.toMovie()
        } else {
            Log.d(TAG, "network failure")
            listOf()
        }
    }
}
