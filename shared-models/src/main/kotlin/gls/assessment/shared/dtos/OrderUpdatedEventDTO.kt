package gls.assessment.shared.dtos

import gls.assessment.shared.enum.OrderStatus
import java.io.Serializable
import java.util.UUID

data class OrderUpdatedEventDTO(
    var orderUUID: UUID?,
    var oldStatus: OrderStatus?,
    var newStatus: OrderStatus?,
    var contacts: Set<String>?,
    var items: Set<String>?
) : Serializable {
    constructor() : this(null, null, null, null, null)
}