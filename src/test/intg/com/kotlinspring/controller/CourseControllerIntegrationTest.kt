package com.kotlinspring.controller

import com.kotlinspring.dto.CourseDTO
import com.kotlinspring.entity.Course
import com.kotlinspring.repository.CourseRepository
import com.kotlinspring.util.courseEntityList
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.web.util.UriComponentsBuilder

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@AutoConfigureWebTestClient
class CourseControllerIntegrationTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @Autowired
    lateinit var courseRepository: CourseRepository

    @BeforeEach
    fun setUp() {

        courseRepository.deleteAll()
        courseRepository.saveAll(courseEntityList())
    }

    @Test
    fun addCourse() {
        val courseDTO = CourseDTO(
            null, "Build RESTful APIs with SprintBoot and Kotlin", "SOFTWARE"
        )
        val savedCourseDTO = webTestClient
            .post()
            .uri("/v1/courses")
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CourseDTO::class.java) // expect body assertion for kotlin. this will handle the type and assertion
            .returnResult()
            .responseBody
        // println(savedCourseDTO)
        Assertions.assertTrue {
            savedCourseDTO!!.id != null
        }
    }

    @Test
    fun retrieveAllCourses() {
        val allCourseDTOs = webTestClient
            .get()
            .uri("/v1/courses")
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBodyList(CourseDTO::class.java) // Body List data expectation.
            .returnResult()
            .responseBody

        assertEquals(3, allCourseDTOs!!.size)
    }

    @Test
    fun retrieveAllCourses_ByName() {
        val uri = UriComponentsBuilder.fromUriString("/v1/courses")
            .queryParam("course_name", "SpringBoot")
            .toUriString()

        val allCourseDTOs = webTestClient
            .get()
            .uri(uri)
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBodyList(CourseDTO::class.java) // Body List data expectation.
            .returnResult()
            .responseBody

        assertEquals(2, allCourseDTOs!!.size)
    }

    @Test
    fun updateCourse() {
        // Existing Course
        val course = Course(null, "Build RESTful APIs using SpringBoot and Kotlin", "Development")
        courseRepository.save(course)
        // courseId
        // Updated CourseDTO
        val updatedCourseDTO = Course(null, "Build RESTful APIs using SpringBoot and Kotlin-1", "Development")
        val updatedCourse = webTestClient
            .put()
            .uri("/v1/courses/{courseId}", course.id)
            .bodyValue(updatedCourseDTO)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java) // expect body assertion for kotlin. this will handle the type and assertion
            .returnResult()
            .responseBody

        assertEquals("Build RESTful APIs using SpringBoot and Kotlin-1", updatedCourse!!.name)
    }

    @Test
    fun deleteCourse() {
        // Existing Course
        val course = Course(null, "Build RESTful APIs using SpringBoot and Kotlin", "Development")
        courseRepository.save(course)

        val updatedCourse = webTestClient
            .delete()
            .uri("/v1/courses/{courseId}", course.id)
            .exchange()
            .expectStatus().isNoContent
    }
}