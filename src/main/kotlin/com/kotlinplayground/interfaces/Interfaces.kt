package com.kotlinplayground.interfaces

import com.kotlinplayground.classes.Course

interface CourseRepository {
    fun getById(id: Int): Course
    fun save(course: Course): Int {
        println("Save the course: $course")
        return course.id
    }
}

interface Repository {
    fun getAll(): any
}

class SqlCourseRepository : CourseRepository, Repository {
    override fun getById(id: Int): Course {
        return Course(id, "Reactive programming in Modern Java using project reactor", "Ikram")
    }

    override fun getAll(): any {
        TODO("Not yet implemented")
    }
}

class NoSqlCourseRepository : CourseRepository {
    override fun getById(id: Int): Course {
        return Course(id, "Reactive programming in Modern Java using project reactor", "Ikram")
    }

    override fun save(course: Course): Int {
        println("[NoSqlCourseRepository] Save the course: $course")
        return course.id
    }
}

fun main() {
    val sqlCourseRepository = SqlCourseRepository()
    println("Course is: ${sqlCourseRepository.getById(1)}")

    val noSqlCourseRepository = NoSqlCourseRepository()
    println("Course is: ${noSqlCourseRepository.getById(1)}")
    val courseId = noSqlCourseRepository.save(Course(2, "Reactive programming in Modern Java using project reactor", "Ikram"))
    println("courseId is $courseId")
}
