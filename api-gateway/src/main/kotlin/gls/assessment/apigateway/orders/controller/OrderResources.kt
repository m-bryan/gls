package gls.assessment.apigateway.orders.controller

import gls.assessment.apigateway.orders.proxy.OrderProxy
import gls.assessment.shared.dtos.NewOrderDTO
import gls.assessment.shared.dtos.OrderDTO
import gls.assessment.shared.util.PaginatedDataList
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/orders")
class OrderResources(
    private val orderProxy: OrderProxy
) {

    @GetMapping
    fun getAll(pageable: Pageable): ResponseEntity<PaginatedDataList<OrderDTO>> {
        val customersPage = orderProxy.getAll(pageable)
        return ResponseEntity.ok(customersPage)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<OrderDTO> {
        val orderDTO = orderProxy.getById(id)
        return ResponseEntity.ok(orderDTO)
    }

    @PostMapping
    fun create(@RequestBody newOrderDTO: NewOrderDTO): ResponseEntity<OrderDTO> {
        val orderDTO = orderProxy.create(newOrderDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO)
    }

    @PutMapping("/{id}/status/{status}")
    fun update(
        @PathVariable id: Long,
        @PathVariable status: String
    ): ResponseEntity<OrderDTO> {
        val updatedOrderDTO = orderProxy.update(id, status)
        return ResponseEntity.ok(updatedOrderDTO)
    }
}