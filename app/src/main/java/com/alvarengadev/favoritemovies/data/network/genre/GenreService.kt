package com.alvarengadev.favoritemovies.data.network.genre

import com.alvarengadev.favoritemovies.data.network.genre.response.GenresResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreService {
    @GET("genre/movie/list") fun genre(@Query("api_key") apiKey: String): Call<GenresResult>
}
