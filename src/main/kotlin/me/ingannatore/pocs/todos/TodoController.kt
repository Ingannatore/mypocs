package me.ingannatore.pocs.todos

import me.ingannatore.pocs.todos.services.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("todo")
class TodoController(
    private val service: TodoService,
) {
    @GetMapping(produces = ["application/json"])
    fun getAll(): ResponseEntity<List<Todo>> =
        ResponseEntity(service.findAll(), HttpStatus.OK)

    @PostMapping(produces = ["application/json"])
    fun post(@RequestBody todo: Todo): ResponseEntity<Todo> =
        ResponseEntity(service.create(todo), HttpStatus.CREATED)

    @PutMapping("/{id}/mark-as-done", produces = ["application/json"])
    fun markAsDone(@PathVariable id: UUID): ResponseEntity<Todo> =
        ResponseEntity(service.markAsDone(id), HttpStatus.OK)
}
