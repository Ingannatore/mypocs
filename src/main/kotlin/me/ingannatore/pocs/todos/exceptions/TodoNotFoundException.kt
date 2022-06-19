package me.ingannatore.pocs.todos.exceptions

import me.ingannatore.pocs.commons.exceptions.ResourceNotFoundException
import java.util.*

class TodoNotFoundException(id: UUID) : ResourceNotFoundException(
    code = 2001,
    message = "TODO not found",
    pointer = "/todo/$id"
)
