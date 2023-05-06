package com.playground.application.service

import com.zaxxer.hikari.HikariPoolMXBean
import kotlinx.coroutines.*
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.Executors

@Service
class CoroutineTransaction(
    private val increaseStudentAgeService: IncreaseStudentAgeService,
    private val hikariPoolMXBean: HikariPoolMXBean,
) {
    val logger = LoggerFactory.getLogger("CoroutineTransaction Test")

    @OptIn(DelicateCoroutinesApi::class)
    val fixedCoroutineScope = newFixedThreadPoolContext(3, "fixedCoroutineScope")
    val threads = Executors.newFixedThreadPool(2)

    @Transactional
    fun coroutineTransaction() {
        runBlocking(Dispatchers.IO) {
            val innerCurrentThread = Thread.currentThread()
            logger.info("Coroutine Start Thread Inner : ${innerCurrentThread.name} id - ${innerCurrentThread.id}")
            launch { increaseStudentAgeService.increase(1, 1) }
            launch { increaseStudentAgeService.increase(2, 1) }
            launch { increaseStudentAgeService.increase(3, 1) }
            logger.info("Coroutine End Thread Inner : ${innerCurrentThread.name} id - ${innerCurrentThread.id}")
            logger.info(
                "connections info total: {}, active: {}, idle: {}, await: {}",
                hikariPoolMXBean.totalConnections,
                hikariPoolMXBean.activeConnections,
                hikariPoolMXBean.idleConnections,
                hikariPoolMXBean.threadsAwaitingConnection
            )
        }
    }

    @Transactional
    fun noCoroutineTransaction() {
        logger.info(
            "connections info total: {}, active: {}, idle: {}, await: {}",
            hikariPoolMXBean.totalConnections,
            hikariPoolMXBean.activeConnections,
            hikariPoolMXBean.idleConnections,
            hikariPoolMXBean.threadsAwaitingConnection
        )
        for (i in 1L..3L) {
            increaseStudentAgeService.increase(i, 1)
        }
    }
}
