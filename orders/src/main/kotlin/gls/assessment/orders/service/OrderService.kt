package gls.assessment.orders.service

import gls.assessment.shared.dtos.NewOrderDTO
import gls.assessment.shared.dtos.OrderDTO
import gls.assessment.shared.enum.OrderStatus
import gls.assessment.shared.util.PaginatedDataList
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
interface OrderService {
    fun create(orderDTO: NewOrderDTO): OrderDTO
    fun update(id: Long, status: String): OrderDTO
    fun getById(id: Long): OrderDTO
    fun getAll(pageable: Pageable): PaginatedDataList<OrderDTO>
}