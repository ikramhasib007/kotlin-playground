package com.kotlinplayground.collections

fun main() {
    var addLambda = { x: Int -> x + x }
    val addResult = addLambda(3)
    println("addResult: $addResult")

    var multiplyLambda = { x:Int, y:Int ->
        println("x is $x and y is $y")
        x * y                   // last statement will assume as lambda body whenever it's multiline
    }
    var multiplyResult = multiplyLambda(2, 3)
    println("multiplyResult: $multiplyResult")
}
