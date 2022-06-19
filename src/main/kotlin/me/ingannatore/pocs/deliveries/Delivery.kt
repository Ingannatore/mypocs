package me.ingannatore.pocs.deliveries

import java.time.LocalDate
import java.util.UUID

class Delivery(
    val id: UUID?,
    val code: String,
    val createdAt: LocalDate,
    val numberOfItems: Int,
    val numberOfPackages: Int,
)
