package me.ingannatore.pocs.todos.db

import me.ingannatore.pocs.todos.Todo
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*

@Service
class TodoDao(
    private val repository: TodoEntityRepository,
) {
    fun findAll(): List<Todo> =
        repository.findAll(Sort.by(Sort.Direction.ASC, "priority"))
            .map { TodoMapper.fromEntity(it) }

    fun findById(id: UUID): Todo? =
        repository.findById(id).orElse(null)
            ?.let { TodoMapper.fromEntity(it) }

    fun save(todo: Todo): Todo =
        TodoMapper.toEntity(todo)
            .let { repository.save(it) }
            .let { TodoMapper.fromEntity(it) }
}
