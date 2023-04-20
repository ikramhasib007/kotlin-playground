package com.kotlinplayground.nulls

data class Movie (
    val id: Int?,
    val name: String
)
fun main() {
    var nameNullable : String? = null
    println("Here some data: $nameNullable")
    nameNullable = "Ikram"
    println("Once again some data: $nameNullable")

    var name: String = "Hasib"
    println(name)

    val movie = Movie(null, "Avengers")
    val savedMovie = saveMovie(movie)
    println("Saved movie: $savedMovie")
}

fun saveMovie(movie: Movie): Movie {
    return movie.copy(2)
}
