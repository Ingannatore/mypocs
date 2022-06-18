package me.ingannatore.pocs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PocsApplication

fun main(args: Array<String>) {
    runApplication<PocsApplication>(*args)
}
