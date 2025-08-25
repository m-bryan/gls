package gls.assessment.customers.service.impl

import gls.assessment.customers.mapper.CustomerMapper
import gls.assessment.customers.repository.CustomerRepository
import gls.assessment.customers.service.CustomerService
import gls.assessment.shared.dtos.CustomerDTO
import gls.assessment.shared.util.PaginatedDataList
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CustomerServiceImpl(
    private val customerRepository: CustomerRepository, private val customerMapper: CustomerMapper
) : CustomerService {

    override fun create(customerDTO: CustomerDTO): CustomerDTO {
        var newCustomerEntity = customerMapper.entityFromDTO(customerDTO)
        newCustomerEntity = customerRepository.save(newCustomerEntity)
        return CustomerDTO(newCustomerEntity)
    }

    override fun update(id: Long, customerDTO: CustomerDTO): CustomerDTO {
        var customerEntity = customerRepository.findById(id).orElseThrow()
        customerMapper.updateEntityFromDTO(customerDTO, customerEntity)
        customerEntity = customerRepository.save(customerEntity)
        return CustomerDTO(customerEntity)
    }

    override fun getById(id: Long): CustomerDTO {
        val customerEntity = customerRepository.findById(id).orElseThrow()
        return CustomerDTO(customerEntity)
    }

    override fun getByUUID(uuid: String): CustomerDTO {
        val uuidObject = UUID.fromString(uuid)
        val customerEntity = customerRepository.findCustomerByUuid(uuidObject).orElseThrow()
        return CustomerDTO(customerEntity)
    }

    override fun getAll(pageable: Pageable): PaginatedDataList<CustomerDTO> {
        val customersPage = customerRepository.findAll(pageable);
        val customersDTOPage = customersPage.map { customerEntity -> CustomerDTO(customerEntity) }
        return PaginatedDataList(customersDTOPage)
    }
}