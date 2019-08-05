package com.derrick.util

import android.app.Application
import com.derrick.database.Show
import com.google.gson.Gson

fun getSampleData(application: Application): List<Show> {
    val fileName = "sample_data.json"
    val jsonString = application.assets.open(fileName).bufferedReader().use {
        it.readText()
    }
    return Gson().fromJson(jsonString, Array<Show>::class.java).toList()
}