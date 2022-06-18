package me.ingannatore.pocs.commons.exceptions

import org.springframework.http.HttpStatus

abstract class ResourceNotFoundException(
    override val code: Int,
    override val message: String,
    override val pointer: String,
) : ApplicationException(code, message, pointer, HttpStatus.NOT_FOUND)