package com.rim.starwars.features.dashboard.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rim.starwars.R
import com.rim.starwars.databinding.ItemMoviesHeaderBinding

/**
 * Created by Rim Gazzah on 4/5/21.
 **/
class MovieHeaderViewHolder(private val binding: ItemMoviesHeaderBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(numItems: Int) {
        binding.itemMovieHeaderTotal.text =
            binding.root.context.getString(R.string.dashboard_total_movies, numItems)
    }

    companion object {
        fun create(parent: ViewGroup): MovieHeaderViewHolder {
            val binding = ItemMoviesHeaderBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
            return MovieHeaderViewHolder(binding)
        }
    }
}