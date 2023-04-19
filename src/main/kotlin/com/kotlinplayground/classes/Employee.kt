package com.kotlinplayground.classes

data class Employee(val id: Int, val name: String)

fun main() {
    val employee = Employee(1, "Ikram Ud Daula")
    val employee1 = Employee(1, "Ikram Ud Daula")
    println(employee)
    println("${employee == employee1}")
    val employee3 = employee.copy(
        id = 3, name = "Javed Hassan"
    )
    println(employee3)

}
