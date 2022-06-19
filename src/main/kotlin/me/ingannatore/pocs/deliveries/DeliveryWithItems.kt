package me.ingannatore.pocs.deliveries

import java.time.LocalDate
import java.util.*

class DeliveryWithItems(
    val id: UUID?,
    val code: String,
    val createdAt: LocalDate = LocalDate.now(),
    val items: MutableSet<DeliveryItem> = mutableSetOf(),
) {
    val numberOfItems: Int get() = items.size
    val numberOfPackages: Int get() = items.sumOf { it.quantity }
}
