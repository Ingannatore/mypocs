package me.ingannatore.pocs.deliveries.db

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "delivery_item")
class DeliveryItemEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "id", columnDefinition = "char(36)")
    val id: UUID?,

    @Column
    val code: String,

    @Column
    val quantity: Int,
)
