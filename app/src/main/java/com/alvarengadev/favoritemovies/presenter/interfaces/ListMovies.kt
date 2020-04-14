package com.alvarengadev.favoritemovies.presenter.interfaces

import com.alvarengadev.favoritemovies.data.domain.Movie

interface ListMovies {

    interface ListMoviesView {
        fun setMovies(movies: List<Movie>)
        fun messageError()
    }

    interface ListMoviesPresenter {
        fun init()
        fun destroyView()
    }
}