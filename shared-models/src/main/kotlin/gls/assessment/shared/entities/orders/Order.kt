package gls.assessment.shared.entities.orders

import gls.assessment.shared.enum.OrderStatus
import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "orders")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,

    val uuid: UUID,

    val customerId: Long,

    val description: String,

    @Enumerated(EnumType.STRING)
    var status: OrderStatus,

    val items: Set<String>,

    val createdAt: LocalDateTime,

    var scheduledAt: LocalDateTime?
)