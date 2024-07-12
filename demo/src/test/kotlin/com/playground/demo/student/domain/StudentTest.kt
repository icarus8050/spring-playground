package com.playground.demo.student.domain

import org.junit.jupiter.api.Test
import java.nio.charset.Charset

class StudentTest {

    @Test
    fun test() {
        val a = "가나다"
        val b = a.toByteArray(Charset.forName("KSC5601"))
        println(b.size)
    }
}
