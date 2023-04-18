package com.kotlinplayground.basics

fun main() {

//    val range = 1..10
//    for (i in range) {
//        println("i: $i")
//    }
//
//    val reverseRange = 10 downTo 1
//    for (i in reverseRange) {
//        println("reverseRange: $i")
//    }
//
//    // loops with skipped
//    // Skip values in the iteration
//    for (i in reverseRange step 2) {
//        println("reverseRange with skip: $i")
//    }

    exploreWhile()

    exploreDoWhile()

}

fun exploreDoWhile() {
    var i = 1
    do {
        println("Value of i is: $i")
        i++
    } while (i < 5)
}

fun exploreWhile() {
    var x = 1
    while (x < 5) {
        println("Value of x is: $x")
        x++
    }
}
