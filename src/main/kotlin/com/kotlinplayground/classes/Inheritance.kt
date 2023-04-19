package com.kotlinplayground.classes

open class User(val name: String) {
    open var isLoggedIn : Boolean = false
    open fun login() {
        println("Inside User class")
    }
}

class Student(name: String) : User(name) {
    override var isLoggedIn : Boolean = false
    override fun login() {
        println("Inside Student class")
        super.login()
    }
}

class Instructor(name: String) : User(name)

fun main() {
    val student = Student("Ikram")
    student.login()
    student.isLoggedIn = true
    println("Student name is ${student.name}")
    println("Student isLoggedIn value is: ${student.isLoggedIn}")

    val instructor = Instructor("John")
    instructor.login()
    println("Instructor name is ${instructor.name}")
}
