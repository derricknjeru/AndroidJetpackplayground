package com.derrick.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ShowDatabaseDao {
    @Insert
    fun builkInsert(shows: List<Show>)


    @Query("SELECT * FROM show_table where movie_id=:movie_id")
    fun getSingleShow(movie_id: Int): Show?


    @Query("SELECT * FROM show_table")
    fun getAllShows(): LiveData<List<Show>>

}