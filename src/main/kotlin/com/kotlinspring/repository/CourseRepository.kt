package com.kotlinspring.repository

import com.kotlinspring.entity.Course
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository

interface CourseRepository: CrudRepository<Course, Int> { // Interaction with Course entity and Int is auto generated id for the entity

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
    fun findByNameContaining(courseName: String) : List<Course> // creating custom query

    @Query(value = "SELECT * FROM COURSES where name like %?1%", nativeQuery = true) // ?1 -> mapping with first argument. In this case, courseName. Second argument mapped with ?2 and so on.
    fun findCourseByName(courseName: String) : List<Course> // implement the above(same) query by using native query
}