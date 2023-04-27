package com.kotlinplayground.collections

import com.kotlinplayground.dataset.Course
import com.kotlinplayground.dataset.CourseCategory
import com.kotlinplayground.dataset.courseList

fun main() {
    val courseList = courseList()

    val devPredicate = { c:Course -> c.category == CourseCategory.DEVELOPMENT }
    val desPredicate = { c:Course -> c.category == CourseCategory.DESIGN }

    exploreFilter(courseList, desPredicate)
}

fun exploreFilter(courseList: MutableList<Course>, predicate: (Course) -> Boolean) {
    courseList
//        .filter { it.category == CourseCategory.DEVELOPMENT }
        .filter { predicate.invoke(it) }
        .forEach {
            it
            println("devCourse: $it")
        }
}
