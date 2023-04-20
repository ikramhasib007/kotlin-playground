package com.kotlinplayground.nulls

data class Movie (
    val id: Int?,
    val name: String
)

fun main() {
    var nameNullable : String? = null
    println("Here some data: $nameNullable")
//    printName(nameNullable!!)
    nameNullable?.run {             // run is a scope function
        printName(this)
    }
    val length = nameNullable?.length ?: 0 // Safe operator ? // Elvis operator ?:
    println("Safe operator [length]: $length")
    nameNullable = "Ikram"
    println("Once again some data: $nameNullable")
    println("Safe operator : ${nameNullable?.length}")

    var name: String = "Hasib"
    printName1(name)

    val movie = Movie(null, "Avengers")
    val savedMovie = saveMovie(movie)
    savedMovie.id!!                         // non null assertion !!
    println(savedMovie.id)
    println("Saved movie: $savedMovie")
}

fun printName(name: String) {
    println(name)
}

fun printName1(name: String?) {
    println("Non name: $name")
}

fun saveMovie(movie: Movie): Movie {
//    return movie
    return movie.copy(1)
}
