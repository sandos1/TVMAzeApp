package com.sandona.tvmazeapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sandona.tvmazeapp.databinding.MovieAdapterLayoutBinding
import com.sandona.tvmazeapp.domain.model.MovieResponse

class MovieAdapter(private val listOfMovie: MutableList<MovieResponse> = mutableListOf()) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    lateinit var onclick: (movie: MovieResponse) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieAdapterLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listOfMovie.get(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onclick(movie)
        }
    }

    override fun getItemCount(): Int {
        return listOfMovie.size
    }

    fun addMovie(movie: List<MovieResponse>) {
        listOfMovie.apply {
            clear()
            addAll(movie)
        }
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(val binding: MovieAdapterLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: MovieResponse) {
            binding.let {
                it.name.text = data.name
                Glide.with(it.TVImage.context)
                    .load(data.imageUrl)
                    .into(it.TVImage)
            }
        }
    }
}
