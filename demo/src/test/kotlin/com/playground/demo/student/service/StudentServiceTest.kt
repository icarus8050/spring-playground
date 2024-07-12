package com.playground.demo.student.service

import com.playground.demo.student.domain.Student
import com.playground.demo.student.domain.StudentRepository
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.jvm.optionals.getOrNull

@SpringBootTest
class StudentServiceTest {
    @Autowired
    private lateinit var studentService: StudentService

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @OptIn(ExperimentalStdlibApi::class)
    @Test
    fun `학생의 나이를 수정한다`() {
        // given
        val id = 1L
        val age = 20

        // when
        studentService.changeAge(id, age)

        // then
        val student: Student? = studentRepository.findById(id).getOrNull()
        student.shouldNotBeNull()
        student.age shouldBe 20
    }
}
