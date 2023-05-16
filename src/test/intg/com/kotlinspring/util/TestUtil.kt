package com.kotlinspring.util

import com.kotlinspring.entity.Course

fun courseEntityList() = listOf<Course>(
    Course(null, "Build RESTful APIs using SpringBoot and Kotlin", "Development"),
    Course(null, "Build Reactive Microservices using Spring Web/Flux/SpringBoot", "Development"),
    Course(null, "Wiremock for Java Developers", "Development")
)