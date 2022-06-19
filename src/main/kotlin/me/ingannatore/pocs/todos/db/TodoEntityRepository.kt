package me.ingannatore.pocs.todos.db

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TodoEntityRepository : JpaRepository<TodoEntity, UUID>
