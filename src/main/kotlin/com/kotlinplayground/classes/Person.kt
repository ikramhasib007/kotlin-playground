package com.kotlinplayground.classes

class Person(
    val name: String = "",
    val age: Int = 0
) {
  fun action() {
    println("$name, age of $age, He/she walks")
  }
}

fun main() {
  val person = Person("Ikram", 34) // No need use 'new' keyword for instantiate a class
    person.action()
    println("Person name is ${person.name}")
    println("Person age is ${person.age}")

    val person1 = Person()
    println("Person name is ${person1.name}")
    println("Person age is ${person1.age}")
}
