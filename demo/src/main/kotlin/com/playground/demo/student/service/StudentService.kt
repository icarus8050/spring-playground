package com.playground.demo.student.service

import com.playground.demo.student.domain.StudentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StudentService(
    private val studentRepository: StudentRepository,
) {
    @Transactional
    fun changeAge(
        id: Long,
        age: Int,
    ) {
        studentRepository.getReferenceById(id).changeAge(age)
    }
}
