package com.alvarengadev.favoritemovies.data.mapper

import com.alvarengadev.favoritemovies.data.domain.Movie
import com.alvarengadev.favoritemovies.data.network.movies.response.MovieResponse

class MovieMapper {
    companion object {
        fun responseToDomain(listMovieResponse: List<MovieResponse>): List<Movie> {
            val listMovies = ArrayList<Movie>()

            for (movieResponse in listMovieResponse) {
                val movie = Movie(
                    movieResponse.title,
                    movieResponse.poster,
                    movieResponse.description,
                    movieResponse.date,
                    movieResponse.genres
                )
                listMovies.add(movie)
            }

            return listMovies
        }
    }
}
