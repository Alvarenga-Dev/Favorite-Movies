package com.alvarengadev.favoritemovies.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alvarengadev.favoritemovies.data.database.dao.MoviesFavoritesDao
import com.alvarengadev.favoritemovies.data.domain.Movie

@Database(version = 1, entities = [Movie::class], exportSchema = false)
abstract class MoviesFavoritesDatabase : RoomDatabase() {
    abstract val moviesFavoritesDao: MoviesFavoritesDao
}