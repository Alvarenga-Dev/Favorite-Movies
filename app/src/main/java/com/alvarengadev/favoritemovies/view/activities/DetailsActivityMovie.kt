package com.alvarengadev.favoritemovies.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.alvarengadev.favoritemovies.R
import com.alvarengadev.favoritemovies.data.database.Controller
import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.presenter.GenresMoviePresenter
import com.alvarengadev.favoritemovies.presenter.interfaces.GenresMovie
import com.alvarengadev.favoritemovies.utils.ConstantsUtils
import com.alvarengadev.favoritemovies.view.adapter.favorites.ListFavoritesAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details_movie.*

class DetailsActivityMovie : AppCompatActivity(), GenresMovie.GenresMovieView {

    private lateinit var movie: Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)

        movie = intent.getSerializableExtra(ConstantsUtils.MOVIE_EXTRA) as Movie

        val movieGenres = GenresMoviePresenter(this, movie)
        movieGenres.init()

        initToolbar(movie.title)
        initComponents(movie)
    }

    private fun initToolbar(title: String) {
        toolbar_details_movie.title = title
        setSupportActionBar(toolbar_details_movie)
        toolbar_details_movie.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar_details_movie.setNavigationOnClickListener { finish() }
    }

    private fun initComponents(movie: Movie) {
        tv_title_movie_details.text = movie.title
        tv_release_date_movie_details.text = movie.date
        tv_description_movie_details.text = movie.description

        val posterDetails = movie.posterDetails ?: movie.poster

        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500/${posterDetails}")
            .into(iv_poster_details)
    }

    private fun isFavorite(): Boolean {
        val listMoviesFavorites = Controller().getMoviesFavorites()
        return !listMoviesFavorites!!.contains(movie)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        if (isFavorite()) {
            menuInflater.inflate(R.menu.menu_not_favorite, menu)
        } else {
            menuInflater.inflate(R.menu.menu_favorite, menu)
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (isFavorite()) {
            item.setIcon(R.drawable.ic_favotite)
            Controller().insertMoviesFavorites(movie)
            ListFavoritesAdapter(Controller().getMoviesFavorites() as ArrayList<Movie>).notifyDataSetChanged()
        } else {
            Toast.makeText(this@DetailsActivityMovie, "...", Toast.LENGTH_SHORT).show()
        }
        return true
    }

    override fun onBackPressed() = finish()

    override fun setGenres(genres: ArrayList<String>) {
        val genre = genres.joinToString(", ")
        tv_genres_movie_details.text = genre
    }

    override fun messageError() = Toast.makeText(this@DetailsActivityMovie, R.string.error_get_genres, Toast.LENGTH_LONG).show()

}
