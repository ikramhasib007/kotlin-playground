package com.kotlinplayground.classes

object Authenticate {

    fun authenticate(username: String, password: String) {
        println("User authenticated for username: $username")
    }
}

fun main() {
    Authenticate.authenticate("ikramhasib007", "abc123")
}
