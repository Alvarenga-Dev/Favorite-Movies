package com.alvarengadev.favoritemovies.utils

import android.app.Application
import androidx.room.Room
import com.alvarengadev.favoritemovies.data.database.MoviesFavoritesDatabase

open class MyApplicationUtils: Application() {
    companion object {
        var database: MoviesFavoritesDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room
            .databaseBuilder(this, MoviesFavoritesDatabase::class.java, "database-movies-favorites")
            .allowMainThreadQueries()
            .build()
    }
}