package gls.assessment.apigateway.customers.proxy

import gls.assessment.shared.dtos.CustomerDTO
import gls.assessment.shared.util.PaginatedDataList
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux


@Service
class CustomerProxy(private val customersWebClient: WebClient) {

    fun create(dto: CustomerDTO): CustomerDTO {
        return customersWebClient.post()
            .uri("/customers")
            .bodyValue(dto)
            .retrieve()
            .bodyToMono(CustomerDTO::class.java)
            .block()!!
    }

    fun update(id: Long, dto: CustomerDTO): CustomerDTO {
        return customersWebClient.put()
            .uri("/customers/{id}", id)
            .bodyValue(dto)
            .retrieve()
            .bodyToMono(CustomerDTO::class.java)
            .block()!!
    }

    fun getByUUID(uuid: String): CustomerDTO {
        return customersWebClient.get()
            .uri("/customers/uuid/{uuid}", uuid)
            .retrieve()
            .bodyToMono(CustomerDTO::class.java)
            .block()!!
    }

    fun getAll(pageable: Pageable): PaginatedDataList<CustomerDTO> {
        return customersWebClient.get()
            .uri(
                "/customers?page={page}&size={size}",
                pageable.pageNumber,
                pageable.pageSize
            )
            .retrieve()
            .bodyToFlux<PaginatedDataList<CustomerDTO>>()
            .blockFirst()!!
    }
}