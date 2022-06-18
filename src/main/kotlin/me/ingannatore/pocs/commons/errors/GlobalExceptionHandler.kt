package me.ingannatore.pocs.commons.errors

import me.ingannatore.pocs.commons.exceptions.ApplicationException
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
class GlobalExceptionHandler {

    @ExceptionHandler
    fun applicationExceptionHandler(ex: ApplicationException): ResponseEntity<ErrorResponse> =
        ResponseEntity(
            ErrorResponseFactory.fromApplicationException(ex),
            ex.status,
        )

    @ExceptionHandler
    fun genericExceptionHandler(ex: Exception): ResponseEntity<ErrorResponse> =
        ResponseEntity(
            ErrorResponseFactory.fromException(ex),
            HttpStatus.INTERNAL_SERVER_ERROR,
        )
}