package me.ingannatore.pocs.messages

import me.ingannatore.pocs.messages.exceptions.MessageNotFoundException
import me.ingannatore.pocs.messages.services.MessageService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("message")
class MessageController(
    var service: MessageService,
) {
    @GetMapping(produces = ["application/json"])
    fun getAll(): List<Message> =
        service.findAll()

    @PostMapping(produces = ["application/json"])
    fun post(@RequestBody message: Message): Message =
        service.create(message)

    @GetMapping("/{id}", produces = ["application/json"])
    fun getOne(@PathVariable id: UUID): Message =
        service.findById(id) ?: throw MessageNotFoundException(id)

    @PutMapping("/{id}/mark-as-read", produces = ["application/json"])
    fun markAsRead(@PathVariable id: UUID): Message =
        service.findById(id)?.let { service.markAsRead(it) } ?: throw MessageNotFoundException(id)
}
