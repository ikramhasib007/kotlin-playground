package com.kotlinplayground.cast

import com.kotlinplayground.classes.Course

fun main() {
    val course = Course(1, "Reactive programming in Modern Java using project reactor", "Ikram")

    checkType(course)
    checkType("course")
    castNumber(1.0)
    castNumber(1)

    val number = 1
    val numberDouble = number.toDouble()
    println(numberDouble)
}

fun castNumber(any: Any) {
    when(any) {
//        any as Double -> println("Value is Double")
        any as? Double -> println("Value is Double") // using safe operator
        any as? Int -> println("Value is Int")
    }
}

fun checkType(type: Any) {
    when(type) {
        is Course -> {
            println(type)
        }
        is String -> {
            println("Yes, i'm the string")
        }
    }
}
