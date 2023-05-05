package com.playground.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class MainApp {
}

fun main(args: Array<String>) {
    runApplication<MainApp>(*args)
}
