package com.kotlinplayground.basics

fun main() {

    for (i in 1..5) {
        println("Value of i is: $i")
        if(i === 3) break // break
    }

    label()

    for (i in 1..5) {
        println("Value return of i is: $i")
        if(i === 3) return // return
    }

    println("End of the program!")
}

fun label() {
    loop@ for (i in 1..5) { // label
        println("i in: $i")
//        if (i === 3) break@loop
        innerLoop@ for (j in 1..5) { // label
            println("j in $j")
//            if(j === 2) break@innerLoop
            if(j === 2) continue@loop
        }
    }
}
