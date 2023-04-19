package com.kotlinplayground.classes

import java.lang.IllegalArgumentException

class Item {
  var name: String = ""
  var price: Double = 0.0
    get() {
      println("Inside Getter")
      return field
    }
    set(value) {
      if(value>0.0) {
        println("Inside Setter")
        field = value
      } else {
        throw IllegalArgumentException("Negative value doesn't allowed")
      }
    }

  constructor(itemName: String) {
    name = itemName
  }
}

fun main() {
  val item = Item("iPhone")
    println("Item name is ${item.name}")
    println("Item name is $item")

    item.price = 10.0
    println("${item.price}")

}
