package com.kotlinspring.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class GreetingsService {

    @Value("\${message}") // @Value, which read the profile (dynamically loads when application starts, application.yml file under the resources' folder) and assign to the variable
    lateinit var message: String // lateinit modifier does the init the variable after the spring boot application runs

    fun retrieveGreeting(name: String) = "$name, $message"
}