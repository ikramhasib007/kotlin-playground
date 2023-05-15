package com.kotlinspring.service

import com.kotlinspring.dto.CourseDTO
import com.kotlinspring.entity.Course
import com.kotlinspring.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(val courseRepository: CourseRepository) {

    companion object : KLogging()
    fun addCourse(courseDTO: CourseDTO): CourseDTO {
        val courseEntity = courseDTO.let {
            Course(id = null, name = it.name, category = it.category)
        }

        courseRepository.save(courseEntity)

        println("Course is saved: $courseEntity")

        return courseEntity.let {
            CourseDTO(it.id, it.name, it.category)
        }
    }
}
