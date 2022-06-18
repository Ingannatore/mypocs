package me.ingannatore.pocs.messages.services

import me.ingannatore.pocs.messages.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface MessageRepository: JpaRepository<Message, UUID>
