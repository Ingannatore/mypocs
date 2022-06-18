package me.ingannatore.pocs.messages.services

import me.ingannatore.pocs.commons.validation.ResourceValidator
import me.ingannatore.pocs.messages.Message
import me.ingannatore.pocs.messages.exceptions.MessageValidationException
import org.springframework.stereotype.Service

@Service
class MessageValidator : ResourceValidator<Message>() {
    override fun validate(it: Message) {
        if (it.text.isBlank()) {
            throw MessageValidationException()
        }
    }
}
