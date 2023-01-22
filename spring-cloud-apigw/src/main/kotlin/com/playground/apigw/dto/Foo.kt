package com.playground.apigw.dto

data class Foo(
    val name: String,
) {
    fun hello(): String {
        return name
    }
}
