package me.ingannatore.pocs.messages.services

import me.ingannatore.pocs.messages.Message
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.UUID

@Service
class MessageService(
    private val validator: MessageValidator,
    private val repository: MessageRepository,
) {
    fun findAll(): List<Message> =
        repository.findAll()

    fun findById(id: UUID): Message? =
        repository.findById(id).orElse(null)

    fun create(message: Message): Message {
        validator.validate(message)
        return repository.save(message)
    }

    fun markAsRead(message: Message): Message =
        if (message.hasNotBeenRead) {
            message.readAt = LocalDate.now()
            repository.save(message)
        } else {
            message
        }
}
