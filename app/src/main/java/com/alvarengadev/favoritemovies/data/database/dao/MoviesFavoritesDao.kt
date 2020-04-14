package com.alvarengadev.favoritemovies.data.database.dao

import androidx.room.*
import com.alvarengadev.favoritemovies.data.domain.Movie

@Dao
interface MoviesFavoritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE) fun insert(movie: Movie)

    @Delete fun delete(movie: Movie)

    @Query("SELECT * FROM movies") fun getAll(): List<Movie>

}
