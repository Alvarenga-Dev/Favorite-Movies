package com.alvarengadev.favoritemovies.utils

class GenresConvertUtils {
    companion object {
        fun listIntToString(genresId: List<Int>): String = genresId.joinToString(", ")

        fun stringToListInt(genresId: String): List<Int>{
            val listIdString = genresId.split(", ")
            val listIdInt = ArrayList<Int>()
            listIdString.map {listIdInt.add(it.toInt())}
            return listIdInt
        }
    }
}