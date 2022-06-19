package me.ingannatore.pocs.deliveries.db

import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import java.time.LocalDate
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "delivery")
class DeliveryEntity(
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(name = "id", columnDefinition = "char(36)")
    val id: UUID?,

    @Column
    val code: String,

    @Column
    var createdAt: LocalDate,

    @Column
    val numberOfItems: Int,

    @Column
    val numberOfPackages: Int,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "delivery_id")
    var items: Set<DeliveryItemEntity>,
)
