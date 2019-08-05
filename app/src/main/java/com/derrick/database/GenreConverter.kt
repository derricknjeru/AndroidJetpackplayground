package com.derrick.database

import androidx.room.TypeConverter

class GenreConverter {
    @TypeConverter
    fun gettingListFromString(genreIds: String): List<Int> {
        val list = ArrayList<Int>()

        val array = genreIds.split(",".toRegex()).dropLastWhile {
            it.isEmpty()
        }.toTypedArray()

        for (s in array) {
            if (s.isNotEmpty()) {
                list.add(Integer.parseInt(s))
            }
        }
        return list
    }

    @TypeConverter
    fun writingStringFromList(list: List<Int>): String {
        var genreIds = ""
        for (i in list) {
            genreIds += ",$i"
        }
        return genreIds
    }
}
