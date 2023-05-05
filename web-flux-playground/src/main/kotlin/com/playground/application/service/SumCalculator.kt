package com.playground.application.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class SumCalculator {
    fun sum(value: Flux<Long>): Mono<Long> {
        println("before sum thread : ${Thread.currentThread().name}")
        val result = value
            .reduce { a, b -> a + b }
            .log()
            .map {
                it + 1L
            }
            .map {
                it * 100L
            }
            .log()
        println("after sum thread : ${Thread.currentThread().name}")
        return result
    }
}
