package com.kotlinspring.controller

import com.kotlinspring.dto.CourseDTO
import com.kotlinspring.service.CourseService
import com.kotlinspring.util.courseDTO
import com.kotlinspring.util.courseEntityList
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.reactive.server.WebTestClient

@WebMvcTest(controllers = [CourseController::class])
@AutoConfigureWebTestClient
class CourseControllerUnitTest {
    @Autowired
    lateinit var webTestClient: WebTestClient

    @MockkBean
    lateinit var courseServiceMock: CourseService

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

        every { courseServiceMock.retrieveAllCourses() }.returnsMany(
            listOf(
                courseDTO(1), courseDTO(2), courseDTO(3)
            )
        )

        // Both mocks will works fine

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
}