package com.kotlinplayground.classes

class Person(
    val name: String = "",
    val age: Int = 0
) {
  var email: String = ""
  constructor(_email: String, _name: String = "", _age: Int = 0): this (_name, _age) {
    email = _email
  }
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

    val person2 = Person(_email = "ikramhasib007@gmail.com", _name = "Ikram", _age = 34)
    println("Person name is ${person2.name} & age is ${person2.age} & email is ${person2.email}")

}
