package com.playground.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@SpringBootApplication
class MainApp {
}

fun main(args: Array<String>) {
    runApplication<MainApp>(*args)
}
