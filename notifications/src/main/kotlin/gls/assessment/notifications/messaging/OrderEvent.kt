package gls.assessment.notifications.messaging

import gls.assessment.shared.dtos.OrderUpdatedEventDTO
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class OrderEventListener {

    @RabbitListener(queues = ["notifications.order.queue"])
    fun handleOrderUpdatedEvent(orderUpdatedEventDTO: OrderUpdatedEventDTO) {
        println("📥 Received OrderUpdatedEvent for orderId=${orderUpdatedEventDTO.orderUUID}")
        println("Items: ${orderUpdatedEventDTO.items}")
        println("Contacts to notify: ${orderUpdatedEventDTO.contacts}")
        orderUpdatedEventDTO.contacts?.forEach { println("sending to: ${it}") }
    }
}