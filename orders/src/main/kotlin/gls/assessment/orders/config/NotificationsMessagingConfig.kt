package gls.assessment.orders.config

import org.springframework.amqp.core.TopicExchange
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class NotificationsExchangeConfig {

    private val topicExchange: String = "notifications.order"

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(topicExchange)
    }
}