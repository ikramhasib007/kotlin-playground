package com.kotlinplayground.classes

open class User(val name: String) {
    fun login() {
        println("Inside the User class")
    }
}

class Student(name: String) : User(name)

class Instructor(name: String) : User(name)

fun main() {
    val student = Student("Ikram")
    student.login()
    println("Name is ${student.name}")

    val instructor = Instructor("John")
    instructor.login()
    println("Name is ${instructor.name}")
}
