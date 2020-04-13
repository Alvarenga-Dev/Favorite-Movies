package com.alvarengadev.favoritemovies.data.network.genre.response

import com.squareup.moshi.Json

data class GenresResult(@field:Json(name = "genres") val genres: List<GenreResponse>)
