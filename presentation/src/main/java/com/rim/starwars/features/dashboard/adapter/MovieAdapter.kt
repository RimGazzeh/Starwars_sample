package com.rim.starwars.features.dashboard.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rim.domain.models.entities.Movie
import com.rim.starwars.features.dashboard.viewholder.MovieHeaderViewHolder
import com.rim.starwars.features.dashboard.viewholder.MovieViewHolder

/**
 * Created by Rim Gazzah on 4/5/21.
 **/
class MovieAdapter(private val onItemClickAction: (Movie) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mDataSource: List<Movie> = listOf()

    private enum class ItemType(val value: Int) {
        HEADER_ITEM(0), DATA_ITEM(1)
    }

    fun setData(newData: List<Movie>) {
        mDataSource = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ItemType.HEADER_ITEM.value) {
            MovieHeaderViewHolder.create(parent)
        } else {
            MovieViewHolder.create(parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == ItemType.HEADER_ITEM.value) {
            (holder as MovieHeaderViewHolder).bind(itemCount - 1)
        } else {
            (holder as MovieViewHolder).bind(mDataSource[position - 1], onItemClickAction)
        }
    }

    override fun getItemCount() = mDataSource.size + 1 // for the header

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            ItemType.HEADER_ITEM.value
        } else {
            ItemType.DATA_ITEM.value
        }
    }
}