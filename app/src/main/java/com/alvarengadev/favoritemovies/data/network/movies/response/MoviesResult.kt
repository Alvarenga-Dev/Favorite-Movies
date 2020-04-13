package com.alvarengadev.favoritemovies.data.network.movies.response

import com.squareup.moshi.Json

data class MoviesResult(@field:Json(name = "results") val results: List<MovieResponse>)