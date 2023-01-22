package com.playground.apigw.dto

import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FooTest {

    @Test
    fun fooTest() {
        // given
        val name = "test"

        // when
        val foo = Foo(name = name)

        // then
        foo.shouldNotBeNull()
        foo.name shouldBe name
    }

    @Test
    fun helloTest() {
        // given
        val name = "test"

        // when
        val foo = Foo(name = name)

        // then
        foo.hello() shouldBe name
    }
}
