package me.ingannatore.pocs.deliveries.db

import me.ingannatore.pocs.deliveries.Delivery
import me.ingannatore.pocs.deliveries.DeliveryWithItems
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class DeliveryDao(
    private val repository: DeliveryEntityRepository,
) {
    fun findAll(): List<Delivery> =
        repository.findAll(Sort.by(Sort.Direction.ASC, DeliveryEntity::createdAt.name))
            .map { DeliveryEntityMapper.toDelivery(it) }

    fun findById(id: UUID): DeliveryWithItems? =
        repository.findById(id).orElse(null)
            ?.let { DeliveryEntityMapper.toDeliveryWithItems(it) }

    fun save(delivery: DeliveryWithItems): DeliveryWithItems =
        DeliveryEntityMapper.fromDeliveryWithItems(delivery)
            .let { repository.save(it) }
            .let { DeliveryEntityMapper.toDeliveryWithItems(it) }
}
