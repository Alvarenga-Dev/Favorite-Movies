package com.alvarengadev.favoritemovies.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.alvarengadev.favoritemovies.R
import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.presenter.ListMoviesPresenter
import com.alvarengadev.favoritemovies.presenter.interfaces.ListMovies
import com.alvarengadev.favoritemovies.utils.ConstantsUtils
import com.alvarengadev.favoritemovies.view.adapter.OnItemClickListener
import com.alvarengadev.favoritemovies.view.adapter.movies.ListMoviesAdapter
import kotlinx.android.synthetic.main.activity_popular_movies.*

class PopularMoviesActivity : AppCompatActivity(),
    ListMovies.ListMoviesView, OnItemClickListener {

    private val listMoviesPresenter = ListMoviesPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular_movies)

        initToolbar()
        listMoviesPresenter.init()
    }

    private fun initToolbar() {
        toolbar_movies_popular.title = "Filmes"
        setSupportActionBar(toolbar_movies_popular)
        toolbar_movies_popular.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar_movies_popular.setNavigationOnClickListener { finish() }
    }

    override fun setMovies(movies: List<Movie>) {
        val adapterMovie = ListMoviesAdapter(movies)
        adapterMovie.setOnClickListener(this)

        recycler_movies_popular.apply {
            hasFixedSize()
            layoutManager = LinearLayoutManager(this@PopularMoviesActivity)
            adapter = adapterMovie
            visibility = View.VISIBLE
        }
        progress_bar_movies_popular.visibility = View.INVISIBLE
    }

    override fun messageError() {
        progress_bar_movies_popular.visibility = View.INVISIBLE
        tv_error_list_movies_popular.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        listMoviesPresenter.destroyView()
    }

    override fun onItemClick(movie: Movie) {
        val intent = Intent(applicationContext,DetailsActivityMovie::class.java)
        intent.putExtra(ConstantsUtils.MOVIE_EXTRA, movie)
        startActivity(intent)
    }

}

