package com.alvarengadev.favoritemovies.data.network.movies.response

import com.squareup.moshi.Json

class MovieResponse (
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "original_title") val title: String,
    @field:Json(name = "poster_path") val poster: String,
    @field:Json(name = "backdrop_path") val posterDetails: String?,
    @field:Json(name = "overview") val description: String,
    @field:Json(name = "release_date") val date: String,
    @field:Json(name = "genre_ids") val genres: List<Int>
)
