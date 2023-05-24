package com.kotlinspring.repository

import com.kotlinspring.util.courseEntityList
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import java.util.stream.Stream

@DataJpaTest // For slice of the application/spring context, that is make that DB layer just available to test
@ActiveProfiles("test") // For make sure we are going to use the test context only
class CourseRepositoryIntegrationTest {

    @Autowired
    lateinit var courseRepository: CourseRepository

    @BeforeEach
    fun setUp() {

        courseRepository.deleteAll()
        courseRepository.saveAll(courseEntityList())
    }

    @Test
    fun findByNameContaining() {
        val courses = courseRepository.findByNameContaining("SpringBoot")
        println("courses: $courses")
        assertEquals(2, courses.size)
    }

    @Test
    fun findCourseByName() {
        val courses = courseRepository.findCourseByName("SpringBoot")
        println("courses: $courses")
        assertEquals(2, courses.size)
    }

    @ParameterizedTest // You can run multiple test in a single test by defining @MethodSource annotation
    @MethodSource("courseAndSize") // We can extract the input data by passing a function
    fun findCourseByNameApproach2(name: String, expectedSize: Int) {
        val courses = courseRepository.findCourseByName(name)
        println("courses: $courses")
        assertEquals(expectedSize, courses.size)
    }

    companion object {
        @JvmStatic // Need to tell java, this is a static function
        fun courseAndSize(): Stream<Arguments> {
            return Stream.of(Arguments.arguments("SpringBoot", 2), Arguments.arguments("Wiremock", 1))
        }
    }
}