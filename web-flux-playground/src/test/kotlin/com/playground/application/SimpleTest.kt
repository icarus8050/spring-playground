package com.playground.application

import io.kotest.mpp.log
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class SimpleTest {
    @Test
    fun doOnNextTest() {
        Flux.just(-1L, 0L, 1L)
            .log()
            .flatMap { operator1(it) }
            .subscribe { println(it) }
    }

    fun operator1(num: Long): Flux<Long> {
        return Flux.just(num, num + 1)
    }
}
