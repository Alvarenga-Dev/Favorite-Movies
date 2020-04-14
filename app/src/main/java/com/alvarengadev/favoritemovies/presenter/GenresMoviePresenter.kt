package com.alvarengadev.favoritemovies.presenter

import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.data.mapper.GenreMapper
import com.alvarengadev.favoritemovies.data.network.RetrofitInitializer
import com.alvarengadev.favoritemovies.data.network.genre.response.GenresResult
import com.alvarengadev.favoritemovies.presenter.interfaces.GenresMovie
import com.alvarengadev.favoritemovies.utils.ConstantsUtils
import com.alvarengadev.favoritemovies.utils.GenresConvertUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenresMoviePresenter(private val genresPresenterMovie: GenresMovie.GenresMovieView, private val movie: Movie):
    Callback<GenresResult> {

    fun init() {
        val call = RetrofitInitializer().genresService()
            .genre(ConstantsUtils.API_KEY)
        call.enqueue(this)
    }

    override fun onResponse(call: Call<GenresResult>, response: Response<GenresResult>) {
        if (response.isSuccessful) {
                response.body()?.let {
                    val listGenre = GenreMapper.responseToDomain(it.genres)
                    val genres = ArrayList<String>()
                    val movieGenres = GenresConvertUtils.stringToListInt(movie.genres)
                    for(genre in listGenre) {
                        if (movieGenres.contains(genre.id)) {
                            genres.add(genre.movieGenre)
                        }
                    }
                    genresPresenterMovie.setGenres(genres)
                }
        } else {
            genresPresenterMovie.messageError()
        }
    }

    override fun onFailure(call: Call<GenresResult>, t: Throwable) {
        genresPresenterMovie.messageError()
    }
}
