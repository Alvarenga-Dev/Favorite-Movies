package com.alvarengadev.favoritemovies.presenter.interfaces

interface GenresMovie {
    interface GenresMovieView {
        fun setGenres(genres: ArrayList<String>)
        fun messageError()
    }
}
