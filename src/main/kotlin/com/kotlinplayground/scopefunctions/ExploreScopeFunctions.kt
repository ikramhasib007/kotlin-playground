package com.kotlinplayground.scopefunctions

import com.kotlinplayground.classes.Course
import com.kotlinplayground.classes.CourseCategory

fun main() {

    // exploreApply()
    // exploreAlso()
    exploreLet()
}

fun exploreLet() {
    val numbers = mutableListOf(1,2,3,4,5)
    val result = numbers.map { it*2 }.filter { it > 5 }.let {
        println("it: $it") // runs after the filter is done
        it.sum()
    }
    println(result)

    var name: String? = null
    /* name?.let {
        println(it)
        it.uppercase()
    } */

    name = "Ikram"
    val result1 = name?.let {
        println(it)
        it.uppercase()
    }
    println(result1)
}

fun exploreApply() {
    val course = Course(
        1,
        "Design Thinking in Kotlin",
        "Ikram"
    ).apply { // You want partially modified to the object, you can do with apply scope function
        courseCategory = CourseCategory.DESIGN
//        this.courseCategory = CourseCategory.DESIGN // both are valid
    }

    println("Course: $course")
}

fun exploreAlso() {
    /* val course = Course(
        1,
        "Design Thinking in Kotlin",
        "Ikram"
    ).also { // Also perform some additional work, if modify then plz consider the size effect
        println("Course is :$it")
    } */

    val course = Course(
        1,
        "Design Thinking in Kotlin",
        "Ikram"
    ).apply { // Also, you can chain
        courseCategory = CourseCategory.DESIGN
    }.also { // Also perform some additional work, if modify then plz consider the size effect
        println("Course is :$it")
    }


}
