package com.alvarengadev.favoritemovies.view.adapter.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.favoritemovies.R
import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.view.adapter.OnItemClickListener

class ListMoviesAdapter(private val arrayMovies: List<Movie>) : RecyclerView.Adapter<ListMoviesViewHolder>() {

    private var listener: OnItemClickListener? = null

    fun setOnClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ListMoviesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)

        return ListMoviesViewHolder(view, listener, arrayMovies)
    }

    override fun getItemCount() : Int = arrayMovies.size

    override fun onBindViewHolder(holder: ListMoviesViewHolder, position: Int) {
        holder.bind(arrayMovies[position])
    }

}
