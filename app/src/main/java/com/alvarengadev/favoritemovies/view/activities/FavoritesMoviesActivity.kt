package com.alvarengadev.favoritemovies.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.alvarengadev.favoritemovies.R
import com.alvarengadev.favoritemovies.data.database.Controller
import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.utils.ConstantsUtils
import com.alvarengadev.favoritemovies.view.adapter.OnItemClickListener
import com.alvarengadev.favoritemovies.view.adapter.favorites.ListFavoritesAdapter
import kotlinx.android.synthetic.main.activity_favorites_movies.*

class FavoritesMoviesActivity : AppCompatActivity(), OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites_movies)

        initRecycler()
        initToolbar()
    }

    private fun initToolbar() {
        toolbar_movies_favorites.title = "Movie Favorites"
        setSupportActionBar(toolbar_movies_favorites)
    }

    private fun initRecycler() {
        val adapterMoviesFavorites = ListFavoritesAdapter(Controller().getMoviesFavorites() as ArrayList<Movie>)
        adapterMoviesFavorites.setOnClickListener(this)

        recycler_movies_favorites.apply {
            hasFixedSize()
            layoutManager = GridLayoutManager(this@FavoritesMoviesActivity, 2)
            adapter = adapterMoviesFavorites
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_list_popular, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this@FavoritesMoviesActivity, PopularMoviesActivity::class.java)
        startActivity(intent)
        return true
    }

    override fun onBackPressed() = finish()

    override fun onItemClick(movie: Movie) {
        val intent = Intent(applicationContext,DetailsActivityMovie::class.java)
        intent.putExtra(ConstantsUtils.MOVIE_EXTRA, movie)
        startActivity(intent)
    }

}
