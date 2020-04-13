package com.alvarengadev.favoritemovies.presenter

import com.alvarengadev.favoritemovies.data.mapper.MovieMapper
import com.alvarengadev.favoritemovies.data.network.RetrofitInitializer
import com.alvarengadev.favoritemovies.data.network.movies.response.MoviesResult
import com.alvarengadev.favoritemovies.presenter.interfaces.ListMovies
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListMoviesPresenter(private var view: ListMovies.ListMoviesView?):
    ListMovies.ListMoviesPresenter, Callback<MoviesResult>{

    override fun getMovies() {
        val call = RetrofitInitializer().movieService()
            .list("9ed9bcdc4a30a80d2ca80101f16cf93a")

        call.enqueue(this)
    }

    override fun destroyView() {
        view = null
    }

    override fun onResponse(call: Call<MoviesResult>, response: Response<MoviesResult>) {
        if (response.isSuccessful) {
            response.body()?.let {
                val listMovies = MovieMapper.responseToDomain(it.results)
                view?.setMovies(listMovies)
            }
        } else {
            view?.messageError()
        }
    }

    override fun onFailure(call: Call<MoviesResult>, t: Throwable) {
        view?.messageError()
    }
}