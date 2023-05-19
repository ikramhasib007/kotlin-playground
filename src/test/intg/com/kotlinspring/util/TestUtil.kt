package com.kotlinspring.util

import com.kotlinspring.dto.CourseDTO
import com.kotlinspring.entity.Course

fun courseEntityList() = listOf<Course>(
    Course(null, "Build RESTful APIs using SpringBoot and Kotlin", "Development"),
    Course(null, "Build Reactive Microservices using Spring Web/Flux/SpringBoot", "Development"),
    Course(null, "Wiremock for Java Developers", "Development")
)

fun courseDTO(
    id: Int? = null,
    name: String = "Build RESTful APIs using SpringBoot and Kotlin",
    category: String = "Ikram Ud Daula",
    //instructorId: Int? = 1
) = CourseDTO(
    id,
    name,
    category,
    //instructorId
)