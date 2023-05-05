package com.playground.application.controller

import com.playground.application.service.CoroutineTransaction
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StudentController(
    private val coroutineTransaction: CoroutineTransaction
) {

    @PostMapping("/student/no-coroutine-inc")
    fun noCoroutineInc() {
        coroutineTransaction.noCoroutineTransaction()
    }

    @PostMapping("/student/coroutine-inc")
    fun coroutineIne() {
        coroutineTransaction.coroutineTransaction()
    }
}
