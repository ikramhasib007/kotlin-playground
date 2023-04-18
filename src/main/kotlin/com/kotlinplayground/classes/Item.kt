package com.kotlinplayground.classes

class Item {
  var name: String = ""
  constructor(itemName: String) {
    name = itemName
  }
}

fun main() {
  val item = Item("iPhone")
    println("Item name is ${item.name}")
}
