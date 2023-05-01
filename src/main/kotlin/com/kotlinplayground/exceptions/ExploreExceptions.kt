package com.kotlinplayground.exceptions

fun returnNothing() : Nothing {
    throw RuntimeException("Exception")
}

fun main() {
    println("Name length is : ${nameLength("Ikram")}")
    println("Name length is : ${nameLength(null)}")
    returnNothing()
}

fun nameLength(name: String?): Int? {
//    return try {
//        name!!.length
//    } catch (ex: Exception) {
//        null
//    }
    val result = try {
        name!!.length
    } catch (ex: Exception) {
        println("Exception is $ex")
        null
    }
    return result
}
