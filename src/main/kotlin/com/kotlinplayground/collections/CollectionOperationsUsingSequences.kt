package com.kotlinplayground.collections

import com.kotlinplayground.dataset.Course
import com.kotlinplayground.dataset.CourseCategory
import com.kotlinplayground.dataset.courseList

fun main() {
    val namesListUsingSequence = listOf("Alex", "Ben", "Chloe")
        .asSequence() // It's works with pipeline way; like first item process first to the end and stores the intermediate storage and then proceed one by one
        .filter { it.length >=4 }
        .map { it.uppercase() }
        .toList()
    println("namesListUsingSequence: $namesListUsingSequence")

    val devPredicate = { c:Course -> c.category == CourseCategory.DEVELOPMENT }

    exploreFilterUsingSequence(courseList(), devPredicate)

    val range = 1..100000000
    /* range
        .map { it.toDouble() }
        .forEach {
            println("Value is $it")
        } */ // This will be fail. The error message is "Exception in thread "main" java.lang.OutOfMemoryError: Java heap space"

    range
        .asSequence() // This will work when big volume data computation is required
        .map { it.toDouble() }
        .take(10) // Uses for limit
        .forEach {
            println("Value is $it")
        }
}

fun exploreFilterUsingSequence(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    courseList
//        .filter { it.category == CourseCategory.DEVELOPMENT }
        .asSequence() // It's preferable to use sequence
        .filter { predicate.invoke(it) } // Note: filter {} invoke predicate manually
        .forEach {
            it
            println("devCourse: $it")
        }
}