package com.alvarengadev.favoritemovies.presenter

import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.data.mapper.GenreMapper
import com.alvarengadev.favoritemovies.data.network.RetrofitInitializer
import com.alvarengadev.favoritemovies.data.network.genre.response.GenresResult
import com.alvarengadev.favoritemovies.presenter.interfaces.MovieGenres
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieGenresPresenter(private val genresPresenter: MovieGenres.MovieGenresView, private val movie: Movie): Callback<GenresResult> {

    fun genres() {
        val call = RetrofitInitializer().genresService()
            .genre("9ed9bcdc4a30a80d2ca80101f16cf93a")

        call.enqueue(this)
    }

    override fun onResponse(call: Call<GenresResult>, response: Response<GenresResult>) {
        if (response.isSuccessful) {
                response.body()?.let {
                    val listGenre = GenreMapper.responseToDomain(it.genres)
                    var genres = ArrayList<String>()
                    for(genre in listGenre) {
                        if (movie.genres.contains(genre.id)) {
                            genres.add(genre.movieGenre)
                        }
                    }
                    genresPresenter.setGenres(genres)
                }
        }
    }

    override fun onFailure(call: Call<GenresResult>, t: Throwable) {

    }
}