package com.alvarengadev.favoritemovies.view.adapter

import com.alvarengadev.favoritemovies.data.domain.Movie

interface OnItemClickListener {
    fun onItemClick(movie: Movie)
}
