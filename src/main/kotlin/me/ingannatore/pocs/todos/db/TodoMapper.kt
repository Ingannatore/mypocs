package me.ingannatore.pocs.todos.db

import me.ingannatore.pocs.todos.Todo

object TodoMapper {
    fun fromEntity(it: TodoEntity): Todo =
        Todo(
            id = it.id,
            description = it.description,
            priority = it.priority,
            done = it.done,
        )

    fun toEntity(it: Todo): TodoEntity =
        TodoEntity(
            id = it.id,
            description = it.description,
            priority = it.priority,
            done = it.done,
        )
}
