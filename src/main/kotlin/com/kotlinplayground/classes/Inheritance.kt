package com.kotlinplayground.classes

open class User(val name: String) {
    open var isLoggedIn: Boolean = false
    open fun login() {
        println("Inside User class")
    }

    private fun secret() {
        println("Inside User class")
    }

    protected open fun logout() {
        println("Inside User class")
    }
}

class Student(name: String) : User(name) {
    override var isLoggedIn: Boolean = false

    /** Companion is alternative of static as use of static methods or variables */
    companion object {
        const val noOfEnrolledCourses = 10
        fun country() = "Bangladesh"
    }
    override fun login() {
        println("Inside Student login")
        super.login()
    }

    public override fun logout() {
        println("Inside Student logout")
        super.logout()
    }
}

class Instructor(name: String) : User(name)

fun main() {
    val student = Student("Ikram")
    student.login()
    student.logout()
    student.isLoggedIn = true
    println("Student name is ${student.name}")
    val country = Student.country()
    println("Country is: $country")
    println("noOfEnrolledCourses is: ${Student.noOfEnrolledCourses}")
    println("Student isLoggedIn value is: ${student.isLoggedIn}")

    val instructor = Instructor("John")
    instructor.login()
    println("Instructor name is ${instructor.name}")

    val user = User("Ikram")
//    user.
}
