package com.sandona.tvmazeapp.presentation.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sandona.tvmazeapp.domain.model.MovieResponse
import com.sandona.tvmazeapp.domain.repository.MovieRepository
import com.sandona.tvmazeapp.domain.repository.TAG
import com.sandona.tvmazeapp.domain.usecase.MovieListUseCase
import com.sandona.tvmazeapp.utils.Converter.toMovie
import com.sandona.tvmazeapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val useCase: MovieListUseCase) : ViewModel() {

    private val _movieListLiveData = MutableLiveData<Resource<List<MovieResponse>?>>()
    val movieListLiveData
        get() = _movieListLiveData

    fun getMovieList() {

        viewModelScope.launch(Dispatchers.IO) {
            _movieListLiveData.postValue(Resource.loading(listOf()))
            _movieListLiveData.postValue(Resource.loading(listOf()))
            useCase.invoke().collect{ movieList ->
                if (!movieList.isNullOrEmpty()) {
                    _movieListLiveData.postValue(Resource.success(movieList))
                } else {
                    Log.d(TAG, "network failure")
                    _movieListLiveData.postValue(Resource.error(data = null, message = "netWork failure"))
                }
            }

        }
    }
}
