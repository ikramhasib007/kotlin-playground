package com.kotlinplayground.collections

import com.kotlinplayground.dataset.Course
import com.kotlinplayground.dataset.CourseCategory
import com.kotlinplayground.dataset.courseList

fun main() {
    val courseList = courseList()

    val devPredicate = { c:Course -> c.category == CourseCategory.DEVELOPMENT }
    val desPredicate = { c:Course -> c.category == CourseCategory.DESIGN }

    // exploreFilter(courseList, desPredicate)

    // exploreMap(courseList) only map
    exploreMap(courseList, desPredicate) // combine with filter and map
}

//fun exploreMap(courseList: MutableList<Course>) {
//    val courses = courseList
//        .map { it.name } // will return new list
//        .forEach { // forEach doesn't return any item, that's mean it will return Unit
//            println(it)
//        }
//    println("courses: $courses")
//}

fun exploreMap(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    val courses = courseList
        .filter(predicate) // Note: filter() invoke predicate automatically
        .map { it.name } // will return new list
        .forEach { // forEach doesn't return any item, that's mean it will return Unit
            println(it)
        }
    println("courses: $courses")
}

fun exploreFilter(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    courseList
//        .filter { it.category == CourseCategory.DEVELOPMENT }
        .filter { predicate.invoke(it) } // Note: filter {} invoke predicate manually
        .forEach {
            it
            println("devCourse: $it")
        }
}
