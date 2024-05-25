package com.felipe.passada.navakotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class NavaKotlinApplication

fun main(args: Array<String>) {
    runApplication<NavaKotlinApplication>(*args)
}
