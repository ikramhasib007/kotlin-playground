package com.kotlinplayground.basics

fun main() {
    // immutable
    val name = "Ikram"
    println(name)

    // mutable
    var age = 34
    println(age)
    age = 35
    age = 40
    println(age)

    val course = "Kotlin sprint"
    // String interpolation or string template techniques
    println("Course: $course and the course length is ${course.length}")
}
