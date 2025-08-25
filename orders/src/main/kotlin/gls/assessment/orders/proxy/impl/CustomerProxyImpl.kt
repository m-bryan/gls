package gls.assessment.orders.proxy.impl

import gls.assessment.orders.proxy.CustomerProxy
import gls.assessment.shared.dtos.CustomerDTO
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class CustomerProxyImpl(private val customersWebClient: WebClient) : CustomerProxy {

    override fun getByUUID(uuid: String): CustomerDTO {
        return customersWebClient.get()
            .uri("/customers/uuid/{uuid}", uuid)
            .retrieve()
            .bodyToMono(CustomerDTO::class.java)
            .block()!!
    }

    override fun getById(id: Long): CustomerDTO {
        return customersWebClient.get()
            .uri("/customers/{id}", id)
            .retrieve()
            .bodyToMono(CustomerDTO::class.java)
            .block()!!
    }
}