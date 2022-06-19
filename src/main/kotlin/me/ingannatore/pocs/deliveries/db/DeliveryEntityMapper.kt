package me.ingannatore.pocs.deliveries.db

import me.ingannatore.pocs.deliveries.Delivery
import me.ingannatore.pocs.deliveries.DeliveryItem
import me.ingannatore.pocs.deliveries.DeliveryWithItems

object DeliveryEntityMapper {
    fun toDelivery(it: DeliveryEntity): Delivery =
        Delivery(
            id = it.id,
            code = it.code,
            createdAt = it.createdAt,
            numberOfItems = it.numberOfItems,
            numberOfPackages = it.numberOfPackages,
        )

    fun toDeliveryWithItems(it: DeliveryEntity): DeliveryWithItems =
        DeliveryWithItems(
            id = it.id,
            code = it.code,
            createdAt = it.createdAt,
            items = it.items.map {
                DeliveryItem(
                    id = it.id,
                    code = it.code,
                    quantity = it.quantity
                )
            }.toMutableSet(),
        )

    fun fromDeliveryWithItems(it: DeliveryWithItems): DeliveryEntity =
        DeliveryEntity(
            id = it.id,
            code = it.code,
            createdAt = it.createdAt,
            numberOfItems = it.numberOfItems,
            numberOfPackages = it.numberOfPackages,
            items = it.items.map {
                DeliveryItemEntity(
                    id = it.id,
                    code = it.code,
                    quantity = it.quantity
                )
            }.toSet(),
        )
}
