package com.sandona.tvmazeapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sandona.tvmazeapp.databinding.MovieAdapterLayoutBinding
import com.sandona.tvmazeapp.domain.model.MovieResponse

class MovieListAdapter : ListAdapter<MovieResponse, MovieListAdapter.MovieViewHolder>(MovieDiffCallback) {

    lateinit var onItemClick: (MovieResponse) -> Unit
    object MovieDiffCallback : DiffUtil.ItemCallback<MovieResponse>() {
        override fun areItemsTheSame(oldItem: MovieResponse, newItem: MovieResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MovieResponse, newItem: MovieResponse): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            MovieAdapterLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onItemClick(movie)
        }
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
