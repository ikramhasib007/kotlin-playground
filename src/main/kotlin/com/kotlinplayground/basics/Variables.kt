package com.kotlinplayground.basics

import com.kotlinplayground.functions.courseName
import com.kotlinplayground.functions.topLevelFunction

fun main() {
    // immutable
    val name = "Ikram"
    println(name)

    // mutable
    var age = 34
    println(age)
    age = 35
    println(age)

    val course = "Kotlin sprint"
    // String interpolation or string template techniques
    println("Course: $course and the course length is ${course.length}")

    val multiline = "ABC \n DEF" // multiline (general syntax)
    println(multiline)
    // triple quotes multiline (general syntax)
    val multiline1 = """
        ABD
        DEF
    """.trimIndent()
    println(multiline1)

    val ran = topLevelFunction()
    println("Num is $ran")
    println(courseName)
}
