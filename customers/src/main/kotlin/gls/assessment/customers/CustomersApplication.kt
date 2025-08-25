package gls.assessment.customers

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication

@SpringBootApplication
@EntityScan(basePackages = ["gls.assessment.shared.entities"])
class CustomersApplication

fun main(args: Array<String>) {
    runApplication<CustomersApplication>(*args)
}
