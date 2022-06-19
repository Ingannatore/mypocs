package me.ingannatore.pocs.deliveries

import me.ingannatore.pocs.deliveries.services.DeliveryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("delivery")
class DeliveryController(
    private val service: DeliveryService
) {
    @GetMapping(produces = ["application/json"])
    fun getAll(): ResponseEntity<List<Delivery>> =
        ResponseEntity(service.findAll(), HttpStatus.OK)

    @PostMapping(produces = ["application/json"])
    fun post(@RequestBody delivery: DeliveryWithItems): ResponseEntity<DeliveryWithItems> =
        ResponseEntity(service.create(delivery), HttpStatus.CREATED)

    @GetMapping("/{id}", produces = ["application/json"])
    fun getOne(@PathVariable id: UUID): ResponseEntity<DeliveryWithItems> =
        ResponseEntity(service.findById(id), HttpStatus.OK)
}
