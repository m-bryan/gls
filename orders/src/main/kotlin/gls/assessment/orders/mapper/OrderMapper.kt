package gls.assessment.orders.mapper

import gls.assessment.shared.dtos.CustomerDTO
import gls.assessment.shared.dtos.NewOrderDTO
import gls.assessment.shared.entities.orders.Order
import gls.assessment.shared.enum.OrderStatus
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

@Component
class OrderMapper {
    fun entityFromDTO(newOrderDTO: NewOrderDTO, customerDTO: CustomerDTO): Order {
        return Order(
            null,
            UUID.randomUUID(),
            customerDTO.id!!,
            newOrderDTO.description,
            OrderStatus.NEW,
            newOrderDTO.items,
            LocalDateTime.now(),
            null
        )
    }
}