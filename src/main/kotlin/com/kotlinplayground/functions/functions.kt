package com.kotlinplayground.functions

import java.time.LocalDate

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

fun printPersonDetails(
    name: String,
    email: String = "",
    dob: LocalDate = LocalDate.now()
) {
    println("My name is $name and my email is '$email' and dob is $dob")
}

fun main() {
//    printName("Ikram")
//    val result = addition(1, 2)
//    println("result is $result")
//    val result1 = additionApproach1(1, 2)
//    println("result1 is $result1")

    // Default value parameters
//    printPersonDetails("Ikram", "abc@gmail.com", LocalDate.parse("2003-01-01"))
//    printPersonDetails("Ikram")

    // Named argument or Named para
//    printPersonDetails(name = "Ikram")
    printPersonDetails(name = "Ikram", dob = LocalDate.parse("2003-01-05"))
}

