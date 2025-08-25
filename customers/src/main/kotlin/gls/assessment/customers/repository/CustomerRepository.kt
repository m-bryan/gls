package gls.assessment.customers.repository

import gls.assessment.shared.entities.customers.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {
    fun findCustomerByUuid(uuid: UUID): Optional<Customer>
}