package com.alvarengadev.favoritemovies.data.network.genre.response

import com.squareup.moshi.Json

data class GenreResponse(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val movieGenre: String
)
