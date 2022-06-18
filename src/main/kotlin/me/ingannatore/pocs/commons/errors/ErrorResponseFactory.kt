package me.ingannatore.pocs.commons.errors

import me.ingannatore.pocs.commons.exceptions.ApplicationException
import org.springframework.http.HttpStatus

object ErrorResponseFactory {
    fun fromException(ex: Exception): ErrorResponse =
        ErrorResponse(
            listOf(
                ErrorData(
                    code = HttpStatus.INTERNAL_SERVER_ERROR.value().toString(),
                    status = HttpStatus.INTERNAL_SERVER_ERROR.value().toString(),
                    title = HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase,
                    detail = ex.message ?: "Unexpected internal server error",
                )
            )
        )

    fun fromApplicationException(ex: ApplicationException): ErrorResponse =
        ErrorResponse(
            listOf(
                ErrorData(
                    code = ex.code.toString(),
                    status = ex.status.value().toString(),
                    title = ex.status.reasonPhrase,
                    detail = ex.message,
                    source = ErrorSource(
                        pointer = ex.pointer,
                    )
                )
            )
        )
}