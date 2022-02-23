package com.sandona.tvmazeapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.sandona.tvmazeapp.databinding.FragmentMovieDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShowMovieDetailFragment : Fragment() {
    private val args: ShowMovieDetailFragmentArgs by navArgs()
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding: FragmentMovieDetailsBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        populateUI()
    }

    private fun populateUI() {
        binding.apply {
            val movie = args.movieDetails
            Glide.with(requireContext())
                .load(movie.imageUrl)
                .into(this.TVImage)

            name.text = movie.name
            language.text = movie.language
            type.text = movie.type
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
