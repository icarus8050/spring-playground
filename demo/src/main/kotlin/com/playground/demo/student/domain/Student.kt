package com.playground.demo.student.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    var name: String,
    var age: Int,
) {
    fun changeAge(age: Int) {
        this.age = age
    }
}
