package com.derrick.database

import androidx.room.TypeConverter

class OriginCountryConverter {
    @TypeConverter
    fun gettingListFromString(countries: String): List<String> {
        val list = ArrayList<String>()

        val array = countries.split(",".toRegex()).dropLastWhile {
            it.isEmpty()
        }.toTypedArray()

        for (s in array) {
            if (s.isNotEmpty()) {
                list.add(s)
            }
        }
        return list
    }

    @TypeConverter
    fun writingStringFromList(list: List<String>): String {
        var countries = ""
        for (i in list) {
            countries += ",$i"
        }
        return countries
    }
}