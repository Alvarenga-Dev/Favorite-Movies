package com.alvarengadev.favoritemovies.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alvarengadev.favoritemovies.R
import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.presenter.MovieGenresPresenter
import com.alvarengadev.favoritemovies.presenter.interfaces.MovieGenres
import com.alvarengadev.favoritemovies.utils.Constants
import com.alvarengadev.favoritemovies.utils.GetDisplayUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details_movie.*

class DetailsMovieActivity : AppCompatActivity(), MovieGenres.MovieGenresView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)

        val movie = intent.getSerializableExtra(Constants.MOVIE_EXTRA) as Movie
        val movieGenres = MovieGenresPresenter(this, movie)
        movieGenres.genres()

        initToolbar(movie.title)
        initComponents(movie)

    }

    private fun initToolbar(title: String) {
        toolbarDetailsMovie.title = title
        setSupportActionBar(toolbarDetailsMovie)
    }

    private fun initComponents(movie: Movie) {
        tv_title_movie_details.text = movie.title
        tv_release_date_movie_details.text = movie.date
        tv_description_movie_details.text = movie.description

        val display = GetDisplayUtils(applicationContext)
        display.getMetrics()

        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${movie.poster}")
            .resize(display.getWidth(), display.getHeight() / 2)
            .centerCrop()
            .into(iv_poster_details)

    }

    override fun setGenres(genres: ArrayList<String>) {

        val genre = genres.joinToString(", ")
        tv_genres_details.text = genre
    }
}
