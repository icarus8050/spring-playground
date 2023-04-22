package com.playground.application

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.concurrent.Executors

@Service
class CoroutineTransaction(
    private val increaseStudentAgeService: IncreaseStudentAgeService
) {
    val logger = LoggerFactory.getLogger("CoroutineTransaction Test")

    @OptIn(DelicateCoroutinesApi::class)
    val fixedCoroutineScope = newFixedThreadPoolContext(2, "fixedCoroutineScope")
    val threads = Executors.newFixedThreadPool(2)

    @Transactional
    suspend fun increaseAll() {
        /*(1L..2L).map {
            CoroutineScope(Dispatchers.IO).launch {
                val innerCurrentThread = Thread.currentThread()
                logger.info("Coroutine Start Thread Inner : ${innerCurrentThread.name}")
                runCatching {
                    increaseStudentAgeService.increase(1, 1)
                }.onSuccess {
                    logger.info("Success - $it")
                }.onFailure {
                    logger.info("Fail - $it")
                }
                logger.info("Coroutine End Thread Inner : ${innerCurrentThread.name}")
            }
        }
        delay(3000L)*/
        runBlocking {
            (1L..3L).map {
                launch {
                    val innerCurrentThread = Thread.currentThread()
                    logger.info("Coroutine Start Thread Inner : ${innerCurrentThread.name}")
                    increaseStudentAgeService.increase(it, 1)
                    logger.info("Coroutine End Thread Inner : ${innerCurrentThread.name}")
                }
            }
            /*launch { increaseStudentAgeService.increase(1, 1) }
            launch { increaseStudentAgeService.increase(2, 1) }
            launch { increaseStudentAgeService.increase(3, 1) }*/
        }

        /*
                threads.submit {
                    increaseStudentAgeService.increase(1, 1)
                }
                threads.submit {
                    increaseStudentAgeService.increase(2, 1)
                }
                threads.submit {
                    increaseStudentAgeService.increase(3, 1)
                }
                Thread.sleep(3000L)*/
    }
}
