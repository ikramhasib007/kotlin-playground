package com.kotlinplayground.classes

data class Course(
    val id: Int,
    val name: String,
    val author: String,
    var courseCategory: CourseCategory = CourseCategory.DEVELOPMENT
)

enum class CourseCategory {
    DEVELOPMENT,
    BUSINESS,
    DESIGN,
    MARKETING
}

fun main() {
    val course = Course(1, "Reactive programming in Modern Java using project reactor", "Ikram")
    val course1 = Course(2, "Reactive programming in Modern Java using project reactor", "Ikram")
    println("Print data class: $course")
    println("Checking object equality: ${course == course1}")

    // Clone the object by using copy method
    val course3 = course1.copy(
        id = 3, author = "Ikram1"
    )
    println(course3)

    val marketingCourse = Course(1, "Reactive programming in Modern Java using project reactor", "Ikram", CourseCategory.MARKETING)
    println(marketingCourse)
}
