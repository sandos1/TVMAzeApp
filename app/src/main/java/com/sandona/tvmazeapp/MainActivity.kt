package com.sandona.tvmazeapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandona.tvmazeapp.databinding.ActivityMainBinding
import com.sandona.tvmazeapp.domain.model.MovieResponse
import com.sandona.tvmazeapp.presentation.adapter.MovieAdapter
import com.sandona.tvmazeapp.presentation.viewModel.MovieViewModel
import com.sandona.tvmazeapp.utils.Extension.toastMessage
import com.sandona.tvmazeapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val movieViewModel: MovieViewModel by viewModels()
    lateinit var adapter: MovieAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        movieViewModel.getMovieList()
        setUi()
        setUpObserver()
    }

    fun setUi() {
        binding.recyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = MovieAdapter()
        adapter.onclick = {
            toastMessage(this, String.format(getString(R.string.itemClick), it.name), Toast.LENGTH_LONG)
        }
        binding.recyclerview.adapter = adapter
    }

    private fun setUpObserver() {
        movieViewModel.movieListLiveData.observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { movieList -> retrieveList(movieList) }
                }
                Status.ERROR -> {
                    toastMessage(this, getString(R.string.error))
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
