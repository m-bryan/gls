package gls.assessment.customers.service

import gls.assessment.shared.dtos.CustomerDTO
import gls.assessment.shared.util.PaginatedDataList

interface CustomerService {
    fun create(customerDTO: CustomerDTO): CustomerDTO
    fun update(id: Long, customerDTO: CustomerDTO): CustomerDTO
    fun getById(id: Long): CustomerDTO
    fun getByUUID(uuid: String): CustomerDTO
    fun getAll(pageable: org.springframework.data.domain.Pageable): PaginatedDataList<CustomerDTO>
}