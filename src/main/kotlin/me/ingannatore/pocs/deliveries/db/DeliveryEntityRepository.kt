package me.ingannatore.pocs.deliveries.db

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface DeliveryEntityRepository : JpaRepository<DeliveryEntity, UUID>
