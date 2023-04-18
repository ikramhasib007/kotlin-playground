package com.kotlinplayground.functions

/**
 * The type with only one value: the Unit object. This type corresponds to the void type in Java.
 */
//fun printName(name: String): Unit {
//    println(name)
//}

fun printName(name: String) {
    println(name)
}

fun addition(x: Int, y: Int): Int {
    return x + y
}

//fun additionApproach1(x: Int, y: Int): Int = x + y
fun additionApproach1(x: Int, y: Int) = x + y

fun main() {
    printName("Ikram")
    val result = addition(1, 2)
    println("result is $result")
    val result1 = additionApproach1(1, 2)
    println("result1 is $result1")
}

