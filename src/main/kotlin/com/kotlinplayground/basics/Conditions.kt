package com.kotlinplayground.basics

fun main() {
    // if-else
    // main

    /**
     * if else statement in kotlin
     * It return last statement under the if or else block
     * Last statement is a return statement
     * In kotlin, if-else block is an expression
     */
    var name = "Ikram"
//    if(name.length === 5) {
//        println("Name is Five length")
//    } else {
//        println("Name is not Five length")
//    }
    name = "Jane"
    val result = if(name.length === 5) {
        println("Name is Five length")
        name
    } else {
        println("Name is not Five length")
        name.length
    }
    println("Result: $result")

    var position = 3
//    val medal = if(position === 1) {
//        "GOLD"
//    } else if(position === 2) {
//        "SILVER"
//    } else if(position === 3) {
//        "BRONZE"
//    } else {
//        "No Medal"
//    }
//    println(medal)

//    val medal = when {
//        position === 1 -> "GOLD"
//        position === 2 -> "SILVER"
//        position === 3 -> "BRONZE"
//        else -> "No Medal"
//    }
    position = 3
    val medal = when (position) {
        1 -> "GOLD"
        2 -> "SILVER"
        3 -> "BRONZE"
        else -> "No Medal"
    }
    println(medal)
}
