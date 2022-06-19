package me.ingannatore.pocs.deliveries.services

import me.ingannatore.pocs.deliveries.Delivery
import me.ingannatore.pocs.deliveries.DeliveryWithItems
import me.ingannatore.pocs.deliveries.db.DeliveryDao
import me.ingannatore.pocs.deliveries.exceptions.DeliveryNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class DeliveryService(
    private val dao: DeliveryDao,
) {
    fun findAll(): List<Delivery> =
        dao.findAll()

    fun findById(id: UUID): DeliveryWithItems =
        dao.findById(id) ?: throw DeliveryNotFoundException(id)

    fun create(delivery: DeliveryWithItems): DeliveryWithItems =
        dao.save(delivery)
}
