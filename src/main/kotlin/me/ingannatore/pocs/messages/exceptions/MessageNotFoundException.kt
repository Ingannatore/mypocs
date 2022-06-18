package me.ingannatore.pocs.messages.exceptions

import me.ingannatore.pocs.commons.exceptions.ResourceNotFoundException
import java.util.UUID

class MessageNotFoundException(id: UUID) : ResourceNotFoundException(
    code = 1001,
    message = "Message not found",
    pointer = "/message/$id"
)
