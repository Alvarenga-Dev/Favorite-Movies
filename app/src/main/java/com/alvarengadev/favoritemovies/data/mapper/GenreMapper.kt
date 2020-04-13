package com.alvarengadev.favoritemovies.data.mapper

import com.alvarengadev.favoritemovies.data.domain.Genre
import com.alvarengadev.favoritemovies.data.network.genre.response.GenreResponse

class GenreMapper {
    companion object {
        fun responseToDomain(listGenreResponse: List<GenreResponse>): List<Genre> {
            val listGenres = ArrayList<Genre>()

            for( genreResponse in listGenreResponse) {
                val genre = Genre(
                    genreResponse.id,
                    genreResponse.movieGenre
                )
                listGenres.add(genre)
            }

            return listGenres
        }
    }
}