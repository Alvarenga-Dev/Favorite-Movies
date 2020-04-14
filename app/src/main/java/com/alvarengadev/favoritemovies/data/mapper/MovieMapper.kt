package com.alvarengadev.favoritemovies.data.mapper

import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.data.network.movies.response.MovieResponse
import com.alvarengadev.favoritemovies.utils.GenresConvertUtils

class MovieMapper {
    companion object {
        fun responseToDomain(listMovieResponse: List<MovieResponse>): List<Movie> {
            val listMovies = ArrayList<Movie>()

            for (movieResponse in listMovieResponse) {
                val genresId = GenresConvertUtils.listIntToString(movieResponse.genres)
                val movie = Movie(
                    movieResponse.id,
                    movieResponse.title,
                    movieResponse.poster,
                    movieResponse.posterDetails,
                    movieResponse.description,
                    movieResponse.date,
                    genresId
                )
                listMovies.add(movie)
            }

            return listMovies
        }
    }
}
