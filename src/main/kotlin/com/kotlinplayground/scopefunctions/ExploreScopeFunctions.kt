package com.kotlinplayground.scopefunctions

import com.kotlinplayground.classes.Course
import com.kotlinplayground.classes.CourseCategory

fun main() {

//    exploreApply()
    exploreAlso()
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
