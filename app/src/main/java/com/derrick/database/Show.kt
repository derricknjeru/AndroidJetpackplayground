package com.derrick.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "show_table")
data class Show(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("_id")
    var _id: Long = 0L,
    @SerializedName("original_name")
    var originalName: String? = null,
    @SerializedName("genre_ids")
    var genreIds: List<Int>? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("popularity")
    var popularity: Double = 0.toDouble(),
    @SerializedName("origin_country")
    var originCountry: List<String>? = null,
    @SerializedName("vote_count")
    var voteCount: Int = 0,
    @SerializedName("first_air_date")
    var firstAirDate: String? = null,
    @SerializedName("backdrop_path")
    var backdropPath: String? = null,
    @SerializedName("original_language")
    var originalLanguage: String? = null,
    @ColumnInfo(name = "movie_id")
    @SerializedName("id")
    var movie_id: Int = 0,
    @SerializedName("vote_average")
    var voteAverage: Double = 0.toDouble(),
    @SerializedName("overview")
    @Expose
    var overview: String? = null,
    @SerializedName("poster_path")
    @Expose
    var posterPath: String? = null
)

