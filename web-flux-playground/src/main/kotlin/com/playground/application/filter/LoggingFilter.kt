package com.playground.application.filter

import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

@Component
class LoggingFilter : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        println("Before Logging filter Thread id - ${Thread.currentThread().name}")
        val filter = chain.filter(exchange)
        println("After Logging filter Thread id - ${Thread.currentThread().name}")
        return filter
    }
}
