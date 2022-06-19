package me.ingannatore.pocs.todos.services

import me.ingannatore.pocs.todos.Todo
import me.ingannatore.pocs.todos.db.TodoDao
import me.ingannatore.pocs.todos.exceptions.TodoNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class TodoService(
    private val dao: TodoDao,
    private val validator: TodoValidator,
) {
    fun findAll(): List<Todo> =
        dao.findAll()

    fun create(it: Todo): Todo {
        validator.validate(it)
        return dao.save(it)
    }

    fun markAsDone(id: UUID): Todo =
        dao.findById(id)
            ?.let { dao.save(it.markAsDone()) }
            ?: throw TodoNotFoundException(id)
}
