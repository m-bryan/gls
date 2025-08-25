package gls.assessment.orders.service.impl

import gls.assessment.orders.mapper.OrderMapper
import gls.assessment.orders.proxy.CustomerProxy
import gls.assessment.orders.proxy.messaging.OrderEvent
import gls.assessment.orders.repository.OrderRepository
import gls.assessment.orders.service.OrderService
import gls.assessment.shared.dtos.NewOrderDTO
import gls.assessment.shared.dtos.OrderDTO
import gls.assessment.shared.dtos.OrderUpdatedEventDTO
import gls.assessment.shared.enum.OrderStatus
import gls.assessment.shared.util.PaginatedDataList
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val orderMapper: OrderMapper,
    private val customerProxy: CustomerProxy,
    private val orderEvent: OrderEvent
) :
    OrderService {

    override fun create(orderDTO: NewOrderDTO): OrderDTO {
        val customerDTO = customerProxy.getByUUID(orderDTO.customerUUID)
        var newOrderEntity = orderMapper.entityFromDTO(orderDTO, customerDTO)
        newOrderEntity = orderRepository.save(newOrderEntity)
        return OrderDTO(newOrderEntity, customerDTO)
    }

    override fun update(
        id: Long,
        status: String
    ): OrderDTO {

        var orderEntity = orderRepository.findById(id).orElseThrow();
        val oldStatus = orderEntity.status;
        orderEntity.status = OrderStatus.valueOf(status)
        val customerDTO = customerProxy.getById(orderEntity.customerId);
        orderEntity = orderRepository.save(orderEntity);
        orderEvent.publishOrderUpdatedEvent(
            OrderUpdatedEventDTO(
                orderEntity.uuid,
                oldStatus,
                orderEntity.status,
                setOf(customerDTO.email),
                orderEntity.items
            )
        )
        return OrderDTO(orderEntity, customerDTO);
    }

    override fun getById(id: Long): OrderDTO {
        TODO("Not yet implemented")
    }

    override fun getAll(pageable: Pageable): PaginatedDataList<OrderDTO> {
        TODO("Not yet implemented")
    }
}