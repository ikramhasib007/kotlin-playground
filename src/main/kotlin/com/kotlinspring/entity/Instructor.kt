package com.kotlinspring.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "Instructors")
data class Instructor(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto generated id
    val id : Int?,
    var name : String,
    @OneToMany(
        mappedBy = "instructor", // will map with courses instructor column
        cascade = [CascadeType.ALL], // When the instructor is deleted then all instructor's course will be deleted.
        orphanRemoval = true // if any orphan available then it will be deleted
    )
    var courses : List<Course> = mutableListOf()
)