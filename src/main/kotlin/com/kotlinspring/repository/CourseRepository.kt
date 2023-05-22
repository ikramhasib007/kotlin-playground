package com.kotlinspring.repository

import com.kotlinspring.entity.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Course, Int> { // Interaction with Course entity and Int is auto generated id for the entity

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    fun findByNameContaining(courseName: String) : List<Course> // creating custom query
}