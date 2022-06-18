package me.ingannatore.pocs.messages

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.time.LocalDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "message")
class Message(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "id", columnDefinition = "char(36)")
    val id: UUID?,

    @Column
    val text: String,

    @Column
    var readAt: LocalDate? = null,
) {
    val hasNotBeenRead: Boolean get() = readAt == null
}
