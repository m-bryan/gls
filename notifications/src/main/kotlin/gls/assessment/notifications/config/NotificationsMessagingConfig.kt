package gls.assessment.notifications.config

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.support.converter.SimpleMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class NotificationsExchangeConfig {

    private val topicExchange: String = "notifications.order"

    private val queue: String = "notifications.order.queue"

    @Bean
    fun queue(): Queue? {
        return Queue(queue, true)
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(topicExchange)
    }

    @Bean
    fun binding(queue: Queue?, exchange: TopicExchange): Binding? {
        return BindingBuilder.bind(queue).to(exchange).with("order.updated")
    }

    @Bean
    fun converter(): SimpleMessageConverter {
        val converter = SimpleMessageConverter()
        converter.setAllowedListPatterns(
            listOf(
                "java.util.*",
                "java.lang.*",
                "gls.assessment.shared.dtos.*",
                "gls.assessment.shared.enum.*"
            )
        )
        return converter
    }
}