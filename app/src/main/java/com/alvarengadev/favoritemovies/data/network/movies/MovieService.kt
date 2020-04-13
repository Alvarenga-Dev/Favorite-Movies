package com.alvarengadev.favoritemovies.data.network.movies

import com.alvarengadev.favoritemovies.data.network.movies.response.MoviesResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    fun list(@Query("api_key") apiKey: String) : Call<MoviesResult>
}