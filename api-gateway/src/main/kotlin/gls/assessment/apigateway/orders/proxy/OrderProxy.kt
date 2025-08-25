package gls.assessment.apigateway.orders.proxy

import gls.assessment.shared.dtos.NewOrderDTO
import gls.assessment.shared.dtos.OrderDTO
import gls.assessment.shared.util.PaginatedDataList
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux

@Service
class OrderProxy(private val ordersWebClient: WebClient) {
    fun create(dto: NewOrderDTO): OrderDTO {
        return ordersWebClient.post()
            .uri("/orders")
            .bodyValue(dto)
            .retrieve()
            .bodyToMono(OrderDTO::class.java)
            .block()!!
    }

    fun update(id: Long, status: String): OrderDTO {
        return ordersWebClient.put()
            .uri("/orders/{id}/status/{status}", id, status)
            .bodyValue(status)
            .retrieve()
            .bodyToMono(OrderDTO::class.java)
            .block()!!
    }

    fun getById(id: Long): OrderDTO {
        return ordersWebClient.get()
            .uri("/orders/{id}", id)
            .retrieve()
            .bodyToMono(OrderDTO::class.java)
            .block()!!
    }

    fun getAll(pageable: Pageable): PaginatedDataList<OrderDTO> {
        return ordersWebClient.get()
            .uri(
                "/orders?page={page}&size={size}",
                pageable.pageNumber,
                pageable.pageSize
            )
            .retrieve()
            .bodyToFlux<PaginatedDataList<OrderDTO>>()
            .blockFirst()!!
    }
}