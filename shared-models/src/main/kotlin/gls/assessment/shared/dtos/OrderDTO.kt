package gls.assessment.shared.dtos

import gls.assessment.shared.entities.orders.Order
import gls.assessment.shared.enum.OrderStatus
import java.time.LocalDateTime

class OrderDTO(
    val id: Long?,
    val uuid: String,
    val customer: CustomerDTO,
    val description: String,
    val status: OrderStatus,
    val items: Set<String>,
    val createdAt: LocalDateTime,
    var scheduledAt: LocalDateTime?
) {
    constructor(orderEntity: Order, customerDTO: CustomerDTO) : this(
        orderEntity.id,
        orderEntity.uuid.toString(),
        customerDTO,
        orderEntity.description,
        orderEntity.status,
        orderEntity.items,
        orderEntity.createdAt,
        orderEntity.scheduledAt
    )
}