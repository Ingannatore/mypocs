package me.ingannatore.pocs.commons.exceptions

import org.springframework.http.HttpStatus

abstract class ApplicationException(
    open val code: Int,
    open val pointer: String,
    override val message: String,
    val status: HttpStatus = HttpStatus.INTERNAL_SERVER_ERROR,
) : RuntimeException(message)