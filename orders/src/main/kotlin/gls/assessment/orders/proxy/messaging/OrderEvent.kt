package gls.assessment.orders.proxy.messaging

import gls.assessment.shared.dtos.OrderUpdatedEventDTO

interface OrderEvent {
    fun publishOrderUpdatedEvent(orderUpdatedEventDTO: OrderUpdatedEventDTO)
}