package me.ingannatore.pocs.messages.exceptions

import me.ingannatore.pocs.commons.exceptions.BadRequestException

class MessageValidationException : BadRequestException(
    code = 1002,
    message = "Message is not valid",
    pointer = "/message/attributes/text"
)
