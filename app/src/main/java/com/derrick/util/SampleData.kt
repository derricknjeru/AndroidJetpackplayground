package com.derrick.util

import android.app.Application
import com.derrick.database.Genre
import com.derrick.database.Show
import com.google.gson.Gson

class SampleData {
    companion object {
        fun getTvShows(application: Application): List<Show> {
            val fileName = "sample_data.json"
            val jsonString = application.assets.open(fileName).bufferedReader().use {
                it.readText()
            }
            return Gson().fromJson(jsonString, Array<Show>::class.java).toList()
        }

        fun getGenres(application: Application): List<Genre> {
            val fileName = "genre.json"
            val jsonString = application.assets.open(fileName).bufferedReader().use {
                it.readText()
            }
            return Gson().fromJson(jsonString, Array<Genre>::class.java).toList()
        }
    }
}