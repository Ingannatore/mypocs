package me.ingannatore.pocs.todos.db

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "todo")
class TodoEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "id", columnDefinition = "char(36)")
    val id: UUID?,

    @Column
    val description: String,

    @Column
    val priority: UShort,

    @Column
    val done: Boolean,
)
