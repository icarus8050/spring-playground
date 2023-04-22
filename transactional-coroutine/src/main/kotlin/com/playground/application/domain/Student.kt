package com.playground.application.domain

import javax.persistence.*

@Entity
class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "name")
    val name: String,

    @Column(name = "age")
    var age: Long,
) {
    fun increaseAge(value: Long) {
        age += value
    }
}
