package com.kotlinplayground.functions

/**
 * Top Level Properties
 */
const val courseName = "Kotlin programming!"

/**
 * Top Level Function
 */
fun topLevelFunction(): Int {
    return (1..100).random()
}
fun main() {
    val ran = topLevelFunction()
    println("Num is $ran")
}
