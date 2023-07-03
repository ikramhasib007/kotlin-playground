package com.kotlinspring.service

import com.kotlinspring.dto.CourseDTO
import com.kotlinspring.entity.Course
import com.kotlinspring.exception.CourseNotFoundException
import com.kotlinspring.exception.InstructorNotValidException
import com.kotlinspring.repository.CourseRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class CourseService(
    val courseRepository: CourseRepository,
    val instructorService: InstructorService
) {

    companion object : KLogging()
    fun addCourse(courseDTO: CourseDTO): CourseDTO {
        val instructorOptional = instructorService.findByInstructorId(courseDTO.instructorId!!)
        if(!instructorOptional.isPresent) {
            throw InstructorNotValidException("Instructor not valid for the Id : ${courseDTO.instructorId}")
        }
        val courseEntity = courseDTO.let {// transform for entity type, because this data will save in to the database
            // Course(id = null, name = it.name, category = it.category)
            Course(null, it.name, it.category, instructorOptional.get()) // "instructorOptional.get()" will take cate of building the courseDTO
        }

        courseRepository.save(courseEntity)

        println("Course is saved: $courseEntity")

        return courseEntity.let {// re-transform for return type casting
            CourseDTO(it.id, it.name, it.category, it.instructor!!.id)
        }
    }

    fun retrieveAllCourses(courseName: String?): List<CourseDTO> {
        val courses = courseName?.let {
            courseRepository.findCourseByName(courseName)
        } ?: courseRepository.findAll()
        return courses
            .map {
                CourseDTO(it.id, it.name, it.category)
            }
    }

    fun updateCourse(courseId: Int, courseDTO: CourseDTO): CourseDTO {
        val existingCourse = courseRepository.findById(courseId)
        return if(existingCourse.isPresent) {
            existingCourse.get()
                .let {
                    it.name = courseDTO.name
                    it.category = courseDTO.name
                    courseRepository.save(it)
                    CourseDTO(it.id, it.name, it.category)
                }
        } else {
            throw CourseNotFoundException("No course found for the passed id: $courseId")
        }
    }

    fun deleteCourse(courseId: Int) {
        val existingCourse = courseRepository.findById(courseId)
        if(existingCourse.isPresent) {
            existingCourse.get()
                .let {
                    it.id?.let { it1 -> courseRepository.deleteById(it1) }
                }
        } else {
            throw CourseNotFoundException("No course found for the passed id: $courseId")
        }
    }

}
