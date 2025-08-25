package gls.assessment.apigateway.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {

    @Value("\${proxy.services.customers}")
    private lateinit var customersBaseUrl: String

    @Value("\${proxy.services.orders}")
    private lateinit var ordersBaseUrl: String

    @Bean("customersWebClient")
    fun customersWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl(customersBaseUrl)
            .build();
    }

    @Bean("ordersWebClient")
    fun ordersWebClient(): WebClient {
        return WebClient.builder()
            .baseUrl(ordersBaseUrl)
            .build();
    }
}