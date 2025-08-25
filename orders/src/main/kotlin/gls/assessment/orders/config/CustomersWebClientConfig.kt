package gls.assessment.orders.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class CustomersWebClientConfig {

    @Value("\${proxy.services.customers}")
    private lateinit var customersBaseUrl: String

    @Bean("customersWebClient")
    fun customersWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl(customersBaseUrl)
            .build();
    }
}