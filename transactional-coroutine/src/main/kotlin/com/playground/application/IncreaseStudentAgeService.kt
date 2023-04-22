package com.playground.application

import com.playground.application.domain.StudentRepository
import org.slf4j.LoggerFactory
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager


@Service
class IncreaseStudentAgeService(
    private val studentRepository: StudentRepository
) {
    val logger = LoggerFactory.getLogger("IncreaseStudentAgeService Test")

    @Transactional
    fun increase(id: Long, value: Long) {
        val currentThread = Thread.currentThread()
        logger.info("Transaction Start Thread : ${currentThread.name} id - $id")
        logger.info("CurrentTransactionName : ${TransactionSynchronizationManager.getCurrentTransactionName()}")
        val student = studentRepository.findByIdOrNull(id) ?: return
        logger.info("Student id - ${student.id}, age - ${student.age}")
        Thread.sleep(1000L)
        student.increaseAge(value)
        studentRepository.save(student)
        if (student.id == 3L) {
            throw IllegalStateException()
        }
        logger.info("Transaction End Thread : ${currentThread.name} id - $id")
    }
}
