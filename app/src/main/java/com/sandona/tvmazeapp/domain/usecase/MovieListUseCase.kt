package com.sandona.tvmazeapp.domain.usecase

import com.sandona.tvmazeapp.domain.model.MovieResponse
import com.sandona.tvmazeapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieListUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(): Flow<List<MovieResponse>> = repository.allMovieList()
}
