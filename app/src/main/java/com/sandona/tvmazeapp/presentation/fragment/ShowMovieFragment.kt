package com.sandona.tvmazeapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandona.tvmazeapp.R
import com.sandona.tvmazeapp.databinding.FragmentShowmovieListBinding
import com.sandona.tvmazeapp.presentation.adapter.MovieListAdapter
import com.sandona.tvmazeapp.presentation.viewModel.MovieViewModel
import com.sandona.tvmazeapp.utils.Extension
import com.sandona.tvmazeapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowMovieFragment : Fragment() {
    private val movieViewModel: MovieViewModel by viewModels()
    private val movieListAdapter: MovieListAdapter by lazy {
        MovieListAdapter()
    }
    private var _binding: FragmentShowmovieListBinding? = null
    private val binding: FragmentShowmovieListBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShowmovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieViewModel.getMovieList()
        setUi()
        setUpObserver()
    }

    private fun setUi() {
        binding.movieListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        movieListAdapter.onItemClick = {
            Extension.toastMessage(
                requireContext(),
                String.format(getString(R.string.itemClick), it.name),
                Toast.LENGTH_LONG
            )
            val direction = ShowMovieFragmentDirections.actionShowMovieFragmentToShowMovieDetailFragment(it)
            findNavController().navigate(direction)
        }
        binding.movieListRecyclerView.adapter = movieListAdapter
    }

    private fun setUpObserver() {
        movieViewModel.movieListLiveData.observe(this) {
            when (it.status) {
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    it.data?.let { movieList -> movieListAdapter.submitList(movieList) }
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Extension.toastMessage(requireContext(), getString(R.string.error))
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
