package gls.assessment.customers.controller

import gls.assessment.customers.service.CustomerService
import gls.assessment.shared.dtos.CustomerDTO
import gls.assessment.shared.util.PaginatedDataList
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController(
    private val customerService: CustomerService
) {

    @GetMapping
    fun getAll(pageable: Pageable): ResponseEntity<PaginatedDataList<CustomerDTO>> {
        val customersPage = customerService.getAll(pageable)
        return ResponseEntity.ok(customersPage)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<CustomerDTO> {
        val customerDTO = customerService.getById(id)
        return ResponseEntity.ok(customerDTO)
    }

    @GetMapping("uuid/{uuid}")
    fun getById(@PathVariable uuid: String): ResponseEntity<CustomerDTO> {
        val customerDTO = customerService.getByUUID(uuid)
        return ResponseEntity.ok(customerDTO)
    }

    @PostMapping
    fun create(@RequestBody customerDTO: CustomerDTO): ResponseEntity<CustomerDTO> {
        val newCustomerDTO = customerService.create(customerDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(newCustomerDTO)
    }

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody customerDTO: CustomerDTO
    ): ResponseEntity<CustomerDTO> {
        val updatedCustomerDTO = customerService.update(id, customerDTO)
        return ResponseEntity.ok(updatedCustomerDTO)
    }
}