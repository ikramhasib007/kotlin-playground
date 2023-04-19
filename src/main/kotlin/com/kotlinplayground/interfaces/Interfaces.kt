package com.kotlinplayground.interfaces

import com.kotlinplayground.classes.Course

interface CourseRepository {
    val isCoursePersisted: Boolean
    fun getById(id: Int): Course
    fun save(course: Course): Int {
        println("Save the course: $course")
        return course.id
    }
}

interface Repository {
    fun getAll(): Unit;
}

class SqlCourseRepository : CourseRepository, Repository {
    override var isCoursePersisted: Boolean = false
    override fun getById(id: Int): Course {
        return Course(id, "Reactive programming in Modern Java using project reactor", "Ikram")
    }

    override fun save(course: Course): Int {
        isCoursePersisted = true
        return super.save(course)
    }

    override fun getAll(): Unit {
        TODO("Not yet implemented")
    }
}

class NoSqlCourseRepository : CourseRepository {
    override var isCoursePersisted: Boolean = false

    override fun getById(id: Int): Course {
        return Course(id, "Reactive programming in Modern Java using project reactor", "Ikram")
    }

    override fun save(course: Course): Int {
        println("[NoSqlCourseRepository] Save the course: $course")
        isCoursePersisted = true
        return course.id
    }
}

interface A {
    fun doSomething() {
        println("do Somethings in A")
    }
}
interface B {
    fun doSomething() {
        println("do Somethings in B")
    }
}

class AB : A, B {
    override fun doSomething() {
        super<A>.doSomething()
        super<B>.doSomething()
        println("do Somethings in AB")
    }

}

fun main() {
    val sqlCourseRepository = SqlCourseRepository()
    println("Course is: ${sqlCourseRepository.getById(1)}")

    val noSqlCourseRepository = NoSqlCourseRepository()
    println("Course is: ${noSqlCourseRepository.getById(1)}")
    val courseId = noSqlCourseRepository.save(Course(2, "Reactive programming in Modern Java using project reactor", "Ikram"))
    println("courseId is $courseId")
    println("noSqlCourseRepository: ${noSqlCourseRepository.isCoursePersisted}")

    val ab = AB()
    println("${ab.doSomething()}")
}
