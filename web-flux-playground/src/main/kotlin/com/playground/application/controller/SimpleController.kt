package com.playground.application.controller

import com.playground.application.service.SumCalculator
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class SimpleController(
    private val sumCalculator: SumCalculator
) {

    @GetMapping("/sum")
    fun sum(
        @RequestParam a: Long,
        @RequestParam b: Long
    ): Mono<Long> {
        println("before controller thread : ${Thread.currentThread().name}")
        val result = sumCalculator.sum(Flux.just(a, b))
        println("after controller thread : ${Thread.currentThread().name}")
        return result
    }
}
