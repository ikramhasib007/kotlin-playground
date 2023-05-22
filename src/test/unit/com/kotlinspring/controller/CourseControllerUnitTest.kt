package com.kotlinspring.controller

import com.kotlinspring.dto.CourseDTO
import com.kotlinspring.entity.Course
import com.kotlinspring.service.CourseService
import com.kotlinspring.util.courseDTO
import com.kotlinspring.util.courseEntityList
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.just
import io.mockk.runs
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody

@WebMvcTest(controllers = [CourseController::class])
@AutoConfigureWebTestClient
class CourseControllerUnitTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var courseServiceMock: CourseService

    @Test
    fun addCourseValidation() {
        val courseDTO = CourseDTO(null, "", "")

        every { courseServiceMock.addCourse(any()) } returns courseDTO(id = 1) // mocking the addCourse function

        val response = webTestClient
            .post()
            .uri("/v1/courses")
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().isBadRequest
            .expectBody(String::class.java)
            .returnResult()
            .responseBody

        assertEquals("courseDTO.category must not be blank, courseDTO.name must not be blank", response)
    }

    @Test
    fun addCourseRuntimeException() {
        val courseDTO = CourseDTO(
            null, "Build RESTful APIs with SprintBoot and Kotlin", "SOFTWARE"
        )

        val errorMessage = "Unexpected error occurred"
        every { courseServiceMock.addCourse(any()) } throws RuntimeException(errorMessage)

        val response = webTestClient
            .post()
            .uri("/v1/courses")
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().is5xxServerError
            .expectBody(String::class.java)
            .returnResult()
            .responseBody

        assertEquals(errorMessage, response)
    }

    @Test
    fun addCourse() {
        val courseDTO = CourseDTO(
            null, "Build RESTful APIs with SprintBoot and Kotlin", "SOFTWARE"
        )

        every { courseServiceMock.addCourse(any()) } returns courseDTO(id = 1) // mocking the addCourse function

        val savedCourseDTO = webTestClient
            .post()
            .uri("/v1/courses")
            .bodyValue(courseDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(CourseDTO::class.java) // expect body assertion for kotlin. this will handle the type and assertion
            .returnResult()
            .responseBody

        Assertions.assertTrue {
            savedCourseDTO!!.id != null
        }
    }

    @Test
    fun retrieveAllCourses() {
        /*
            val courseDTOs = courseEntityList()
            .mapIndexed { index, course -> courseDTO(index + 1, course.name, course.category) }
            every { courseServiceMock.retrieveAllCourses() } returns courseDTOs
        */

        every { courseServiceMock.retrieveAllCourses() }.returnsMany( // return list
            listOf(
                courseDTO(1), courseDTO(2), courseDTO(3)
            )
        )

        // Both mock will works fine

        val allCourseDTOs = webTestClient
            .get()
            .uri("/v1/courses")
            .exchange()
            .expectStatus().is2xxSuccessful
            .expectBodyList(CourseDTO::class.java) // Body List data expectation.
            .returnResult()
            .responseBody

        Assertions.assertEquals(3, allCourseDTOs!!.size)
    }

    @Test
    fun updateCourse() {
        val courseId = 10
        every { courseServiceMock.updateCourse(any(), any()) } returns courseDTO(courseId, "Build RESTful APIs using SpringBoot and Kotlin-1")

        // Updated CourseDTO
        val updatedCourseDTO = Course(null, "Build RESTful APIs using SpringBoot and Kotlin-1", "Development")

        val updatedCourse = webTestClient
            .put()
            .uri("/v1/courses/{courseId}", courseId)
            .bodyValue(updatedCourseDTO)
            .exchange()
            .expectStatus().isOk
            .expectBody(CourseDTO::class.java) // expect body assertion for kotlin. this will handle the type and assertion
            .returnResult()
            .responseBody

        Assertions.assertEquals("Build RESTful APIs using SpringBoot and Kotlin-1", updatedCourse!!.name)
    }

    @Test
    fun deleteCourse() {

        every { courseServiceMock.deleteCourse(any()) } just runs // If any function return nothing/void then mock that function like this

        val updatedCourse = webTestClient
            .delete()
            .uri("/v1/courses/{courseId}", 10)
            .exchange()
            .expectStatus().isNoContent
    }
}