package me.ingannatore.pocs.todos.exceptions

import me.ingannatore.pocs.commons.exceptions.BadRequestException

class TodoValidationException : BadRequestException(
    code = 2002,
    message = "TODO is not valid",
    pointer = "/todo/attributes/description"
)
