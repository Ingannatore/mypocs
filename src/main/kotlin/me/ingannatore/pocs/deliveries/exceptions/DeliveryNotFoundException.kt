package me.ingannatore.pocs.deliveries.exceptions

import me.ingannatore.pocs.commons.exceptions.ResourceNotFoundException
import java.util.UUID

class DeliveryNotFoundException(id: UUID) : ResourceNotFoundException(
    code = 2001,
    message = "Delivery not found",
    pointer = "/delivery/$id"
)
