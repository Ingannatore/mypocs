package me.ingannatore.pocs.todos.services

import me.ingannatore.pocs.commons.validation.ResourceValidator
import me.ingannatore.pocs.todos.Todo
import me.ingannatore.pocs.todos.exceptions.TodoValidationException
import org.springframework.stereotype.Service

@Service
class TodoValidator : ResourceValidator<Todo>() {
    override fun validate(it: Todo) {
        if (it.description.isBlank()) {
            throw TodoValidationException()
        }
    }
}
