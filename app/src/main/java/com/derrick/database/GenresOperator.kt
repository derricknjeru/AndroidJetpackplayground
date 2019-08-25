package com.derrick.database

class GenresOperator(val genre: List<Genre>) {
    operator fun get(_id: Int) = genre.first { it.id == _id }
}