package com.alvarengadev.favoritemovies.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.alvarengadev.favoritemovies.R
import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.presenter.ListMoviesPresenter
import com.alvarengadev.favoritemovies.presenter.interfaces.ListMovies
import com.alvarengadev.favoritemovies.utils.Constants
import com.alvarengadev.favoritemovies.view.adapter.OnItemClickListener
import com.alvarengadev.favoritemovies.view.adapter.movies.ListMoviesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListMovies.ListMoviesView, OnItemClickListener {

    private val listMoviesPresenter = ListMoviesPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        listMoviesPresenter.getMovies()
    }

    private fun initToolbar() {
        toolbar.title = "Filmes"
        setSupportActionBar(toolbar)
    }

    override fun setMovies(movies: List<Movie>) {
        val adapterMovie = ListMoviesAdapter(movies)
        adapterMovie.setOnClickListener(this)

        recycler_movies.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(context)
            adapter = adapterMovie
            visibility = View.VISIBLE
        }
        progressBar.visibility = View.INVISIBLE
    }

    override fun messageError() {
        Toast.makeText(applicationContext, "Deu...", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        listMoviesPresenter.destroyView()
    }

    override fun onItemClick(movie: Movie) {
        val intent = Intent(applicationContext,DetailsMovieActivity::class.java)
        intent.putExtra(Constants.MOVIE_EXTRA, movie)
        startActivity(intent)
    }
}
