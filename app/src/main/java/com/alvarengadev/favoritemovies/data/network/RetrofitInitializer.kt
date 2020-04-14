package com.alvarengadev.favoritemovies.data.network

import com.alvarengadev.favoritemovies.data.network.genre.GenreService
import com.alvarengadev.favoritemovies.data.network.movies.MovieService
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    fun movieService(): MovieService = retrofit.create(MovieService::class.java)

    fun genresService(): GenreService = retrofit.create(GenreService::class.java)

}
