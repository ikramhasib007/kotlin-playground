package com.kotlinspring.entity

import jakarta.persistence.*

@Entity
@Table(name = "Courses")
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto generated id
    val id : Int?,
    var name : String,
    var category : String,
    @ManyToOne(fetch = FetchType.LAZY) // EAGER | LAZY
    @JoinColumn(name = "instructor_id", nullable = false) // When database table is created then the id will add for pointing the relationship.
    val instructor: Instructor? = null
)