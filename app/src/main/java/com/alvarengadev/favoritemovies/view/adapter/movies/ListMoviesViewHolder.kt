package com.alvarengadev.favoritemovies.view.adapter.movies

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.favoritemovies.R
import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.view.adapter.OnItemClickListener
import com.squareup.picasso.Picasso

class ListMoviesViewHolder(itemView: View, listener: OnItemClickListener?, movies: List<Movie>) : RecyclerView.ViewHolder(itemView) {

    private val ivPosterMovies: ImageView = itemView.findViewById(R.id.iv_poster_movies)
    private val tvTitleMovies: TextView = itemView.findViewById(R.id.tv_title_movies)
    private val tvDateMovies: TextView = itemView.findViewById(R.id.tv_date_movies)
    private val tvDescriptionMovies: TextView = itemView.findViewById(R.id.tv_description_movies)

    init {
        itemView.setOnClickListener{
            if (listener != null) {
                val positionRecyclerView = adapterPosition
                if (positionRecyclerView != RecyclerView.NO_POSITION) listener.onItemClick(movies[positionRecyclerView])
            }
        }
    }

    fun bind(movie: Movie) {
        tvTitleMovies.text = movie.title
        tvDateMovies.text = movie.date
        tvDescriptionMovies.text = movie.description

        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${movie.poster}")
            .resize(1100, 1600)
            .centerCrop(1)
            .into(ivPosterMovies)
    }

}
