package com.alvarengadev.favoritemovies.data.database

import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.utils.MyApplicationUtils

class Controller {

    private val actionDatabase = MyApplicationUtils.database?.moviesFavoritesDao

    fun insertMoviesFavorites(movie: Movie) = actionDatabase?.insert(movie)

    fun deleteMoviesFavorites(movie: Movie) = actionDatabase?.delete(movie)

    fun getMoviesFavorites(): List<Movie>? = actionDatabase?.getAll()
}
