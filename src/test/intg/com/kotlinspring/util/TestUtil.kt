package com.kotlinspring.util

import com.kotlinspring.dto.CourseDTO
import com.kotlinspring.dto.InstructorDTO
import com.kotlinspring.entity.Course
import com.kotlinspring.entity.Instructor

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

fun instructorDTO(
    id: Int? = null,
    name: String = "Ikram Ud Daula",
) = InstructorDTO(id, name)

fun courseEntityList(instructor: Instructor? = null) = listOf<Course>(
    Course(null, "Build RESTful APIs using SpringBoot and Kotlin", "Development", instructor),
    Course(null, "Build Reactive Microservices using Spring Web/Flux/SpringBoot", "Development", instructor),
    Course(null, "Wiremock for Java Developers", "Development", instructor)
)

fun instructorEntity(name: String = "Ikram Ud Daula") = Instructor(id = null, name)