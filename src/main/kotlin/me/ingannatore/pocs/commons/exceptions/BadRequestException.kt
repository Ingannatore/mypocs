package me.ingannatore.pocs.commons.exceptions

import org.springframework.http.HttpStatus

abstract class BadRequestException(
    override val code: Int,
    override val message: String,
    override val pointer: String,
) : ApplicationException(code, message, pointer, HttpStatus.BAD_REQUEST)