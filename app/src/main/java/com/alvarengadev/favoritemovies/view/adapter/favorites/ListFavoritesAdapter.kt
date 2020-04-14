package com.alvarengadev.favoritemovies.view.adapter.favorites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.favoritemovies.R
import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.view.adapter.OnItemClickListener

class ListFavoritesAdapter(private val arrayMoviesFavorite: ArrayList<Movie>) : RecyclerView.Adapter<ListFavoritesViewHolder>() {

    private var listener: OnItemClickListener? = null

    fun setOnClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListFavoritesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite_movie, parent, false)
        return ListFavoritesViewHolder(view, listener, arrayMoviesFavorite)
    }

    override fun getItemCount(): Int = arrayMoviesFavorite.size

    override fun onBindViewHolder(holder: ListFavoritesViewHolder, position: Int) {
        holder.bind(arrayMoviesFavorite[position])
    }

}
