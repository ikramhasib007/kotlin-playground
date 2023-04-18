package com.kotlinplayground.classes

class Person {
  fun action() {
    println("Person walks")
  }
}

fun main() {
  val person = Person() // No need use 'new' keyword for instantiate a class
    person.action()
}
