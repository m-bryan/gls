package gls.assessment.customers.mapper

import gls.assessment.shared.dtos.CustomerDTO
import gls.assessment.shared.entities.customers.Customer
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class CustomerMapper {
    fun entityFromDTO(customerDTO: CustomerDTO): Customer {
        return Customer(null, customerDTO.name, customerDTO.surname, customerDTO.email, UUID.randomUUID())
    }

    fun updateEntityFromDTO(customerDTO: CustomerDTO, customerEntity: Customer) {
        customerEntity.name = customerDTO.name
        customerEntity.surname = customerDTO.surname
        customerEntity.email = customerDTO.email
    }
}