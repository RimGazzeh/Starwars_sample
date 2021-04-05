package com.rim.starwars.features.dashboard.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rim.domain.models.entities.Movie
import com.rim.starwars.common.DateHelpers
import com.rim.starwars.databinding.ItemMovieBinding

/**
 * Created by Rim Gazzah on 4/5/21.
 **/
class MovieViewHolder(private val binding: ItemMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie, onItemClickAction: (Movie) -> Unit) {
        binding.itemMovieTitle.text = movie.title
        binding.itemMovieDirector.text = movie.director
        binding.itemMovieProducer.text = movie.producer
        binding.itemMovieDescription.text = movie.openingCrawl
        binding.itemMovieReleaseDate.text = DateHelpers.releaseDateFormat(movie.releaseDate)
        binding.itemMovieContainer.setOnClickListener {
            onItemClickAction(movie)
        }
    }

    companion object {
        fun create(parent: ViewGroup): MovieViewHolder {
            val binding = ItemMovieBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return MovieViewHolder(binding)
        }
    }
}