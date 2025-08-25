package gls.assessment.orders.proxy.messaging.impl

import gls.assessment.orders.proxy.messaging.OrderEvent
import gls.assessment.shared.dtos.OrderUpdatedEventDTO
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class OrderEventPublisher(
    private val template: RabbitTemplate
) : OrderEvent {
    override fun publishOrderUpdatedEvent(orderUpdatedEventDTO: OrderUpdatedEventDTO) {
        template.convertAndSend(
            "notifications.order",
            "order.updated",
            orderUpdatedEventDTO
        )
    }
}