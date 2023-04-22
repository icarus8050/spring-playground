package com.playground.application

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension


@ExtendWith(SpringExtension::class)
@SpringBootTest
class SimpleTest {

    @Autowired
    lateinit var increaseStudentAgeService: IncreaseStudentAgeService

    @Autowired
    lateinit var coroutineTransaction: CoroutineTransaction

    @Test
    fun increaseAgeTest() {
        runBlocking {
            coroutineTransaction.increaseAll()
        }
    }
}
