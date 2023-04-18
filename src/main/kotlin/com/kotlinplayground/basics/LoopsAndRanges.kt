package com.kotlinplayground.basics

fun main() {

    val range = 1..10
    for (i in range) {
        println("i: $i")
    }

    val reverseRange = 10 downTo 1
    for (i in reverseRange) {
        println("reverseRange: $i")
    }

    // loops with skipped
    // Skip values in the iteration
    for (i in reverseRange step 2) {
        println("reverseRange with skip: $i")
    }

}
