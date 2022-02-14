package com.sandona.tvmazeapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandona.tvmazeapp.databinding.ActivityMainBinding
import com.sandona.tvmazeapp.domain.model.MovieResponse
import com.sandona.tvmazeapp.presentation.adapter.MovieAdapter
import com.sandona.tvmazeapp.presentation.viewModel.MovieViewModel
import com.sandona.tvmazeapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val movieViewModel: MovieViewModel by viewModels()
    lateinit var adapter: MovieAdapter
    lateinit var _binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        movieViewModel.getMovieList()
        setUi()
        setUpObserver()
    }

// private val observer = ob

    fun setUi() {
        _binding.recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = MovieAdapter()
        _binding.recyclerview.adapter = adapter
    }

    private fun setUpObserver() {
        movieViewModel.movieListLiveData.observe(this) {
            when (it.status) {
                Status.LOADING -> {
                }
                Status.SUCCESS -> {

                    it.data?.let { movieList -> retrieveList(movieList) }
                }
                Status.ERROR -> {
                }
            }
        }
    }

    private fun retrieveList(movie: List<MovieResponse>) {
        adapter.apply {
            addMovie(movie)
        }
    }
}
