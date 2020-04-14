package com.alvarengadev.favoritemovies.view.adapter.favorites

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.alvarengadev.favoritemovies.R
import com.alvarengadev.favoritemovies.data.database.Controller
import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.view.adapter.OnItemClickListener
import com.squareup.picasso.Picasso

class ListFavoritesViewHolder(itemView: View, listener: OnItemClickListener?, movies: List<Movie>) :
    RecyclerView.ViewHolder(itemView) {

    private val ivPosterMovieFavorite = itemView.findViewById(R.id.iv_poster_movie_favorite) as ImageView
    private val tvTitleMovieFavorite = itemView.findViewById(R.id.tv_title_movie_favorite) as TextView
    private val ivButtonFavorite = itemView.findViewById(R.id.iv_button_movie_favorite) as ImageView

    init {
        itemView.setOnClickListener{
            if (listener != null) {
                val positionRecyclerView = adapterPosition
                if (positionRecyclerView != RecyclerView.NO_POSITION) listener.onItemClick(movies[positionRecyclerView])
            }
        }
    }

    fun bind(movie: Movie) {

        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500${movie.poster}")
            .into(ivPosterMovieFavorite)

        tvTitleMovieFavorite.text = movie.title
        ivButtonFavorite.setOnClickListener{
            it.setBackgroundResource(R.drawable.ic_not_favorite)
        }
    }

}
