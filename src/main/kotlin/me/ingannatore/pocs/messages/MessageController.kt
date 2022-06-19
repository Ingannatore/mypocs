package me.ingannatore.pocs.messages

import me.ingannatore.pocs.messages.exceptions.MessageNotFoundException
import me.ingannatore.pocs.messages.services.MessageService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("message")
class MessageController(
    private var service: MessageService,
) {
    @GetMapping(produces = ["application/json"])
    fun getAll(): ResponseEntity<List<Message>> =
        ResponseEntity(service.findAll(), HttpStatus.OK)

    @PostMapping(produces = ["application/json"])
    fun post(@RequestBody message: Message): ResponseEntity<Message> =
        ResponseEntity(service.create(message), HttpStatus.CREATED)

    @GetMapping("/{id}", produces = ["application/json"])
    fun getOne(@PathVariable id: UUID): ResponseEntity<Message> =
        service.findById(id)
            ?.let { ResponseEntity(it, HttpStatus.OK) }
            ?: throw MessageNotFoundException(id)

    @PutMapping("/{id}/mark-as-read", produces = ["application/json"])
    fun markAsRead(@PathVariable id: UUID): ResponseEntity<Message> =
        service.findById(id)
            ?.let { ResponseEntity(service.markAsRead(it), HttpStatus.OK) }
            ?: throw MessageNotFoundException(id)
}
