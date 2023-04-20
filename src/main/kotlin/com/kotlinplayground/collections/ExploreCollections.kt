package com.kotlinplayground.collections

fun main() {
    val names = listOf("Alex", "Ben", "Chloe")
    println("Names is: $names")

    val namesMutableList = mutableListOf<String>("Alex", "Ben", "Chloe")
    println("Mutable List is: $namesMutableList")
    namesMutableList.add("Adam")
    println("Mutable List is after add: $namesMutableList")

    val set = setOf("Alex", "Ben", "Chloe")
    println("set: $set")
    val mutableSet = mutableSetOf("Alex", "Ben", "Chloe")
    println("mutableSet: $mutableSet")
    mutableSet.add("Adam")
    println("mutableSet after add: $mutableSet")

    val nameAgeMap = mapOf("Ikram" to 34, "Scooby" to 4)
    println("nameAgeMap: $nameAgeMap")

    val nameAgeMutableMap = mutableMapOf("Ikram" to 34, "Scooby" to 4) // "scooby" to 4 => key to value
    println("nameAgeMutableMap: $nameAgeMutableMap")
    nameAgeMutableMap["abc"] = 100
    println("nameAgeMutableMap after : $nameAgeMutableMap")
}
