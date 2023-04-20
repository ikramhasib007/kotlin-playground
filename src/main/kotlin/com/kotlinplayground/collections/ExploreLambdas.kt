package com.kotlinplayground.collections

/**
 * Higher Order Function
 */
fun calculate(x: Int, y: Int, op: (x: Int, y: Int) -> Int): Int {
    return op(x, y)
}

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

    val result = calculate(3, 3) { a, b -> a * b }
    println("Print calculate result: $result")

    val add = calculate(3, 3) { a, b -> a + b }
    println("Print calculate[add] result: $add")
}
