package com.alvarengadev.favoritemovies.data.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movies")
data class Movie constructor(
    @field:PrimaryKey val id: Int,
    @field:ColumnInfo(name = "title") val title: String,
    @field:ColumnInfo(name = "poster") val poster: String,
    @field:ColumnInfo(name = "poster_details") val posterDetails: String?,
    @field:ColumnInfo(name = "description") val description: String,
    @field:ColumnInfo(name = "date") val date: String,
    @field:ColumnInfo(name = "genres") val genres: String
): Serializable