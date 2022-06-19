package me.ingannatore.pocs.todos

import java.util.*

data class Todo(
    val id: UUID?,
    val description: String,
    var priority: UShort = 0u,
    var done: Boolean = false,
) {
    fun markAsDone(): Todo {
        done = true
        return this
    }
}
