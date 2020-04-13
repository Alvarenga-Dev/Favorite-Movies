package com.alvarengadev.favoritemovies.data.domain

import java.io.Serializable

data class Movie constructor(
    val title: String,
    val poster: String,
    val description: String,
    val date: String,
    val genres: List<Int>
): Serializable