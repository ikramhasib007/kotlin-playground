package com.kotlinspring.dto

import jakarta.validation.constraints.NotBlank

data class InstructorDTO (
    val id : Int?,
    @get:NotBlank(message = "instructorDTO.name must not be blank")
    val name : String,
)

/**
 * Controller interact with DTO
 * Database (in this case repository) interact with Entity
 * This is the best practice to separate the data class for front and back
 */