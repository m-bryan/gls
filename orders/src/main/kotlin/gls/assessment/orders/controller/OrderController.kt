package gls.assessment.orders.controller

import gls.assessment.orders.service.OrderService
import gls.assessment.shared.dtos.NewOrderDTO
import gls.assessment.shared.dtos.OrderDTO
import gls.assessment.shared.enum.OrderStatus
import gls.assessment.shared.util.PaginatedDataList
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/orders")
class OrderController(
    private val orderService: OrderService
) {

    @GetMapping
    fun getAll(pageable: Pageable): ResponseEntity<PaginatedDataList<OrderDTO>> {
        val customersPage = orderService.getAll(pageable)
        return ResponseEntity.ok(customersPage)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<OrderDTO> {
        val orderDTO = orderService.getById(id)
        return ResponseEntity.ok(orderDTO)
    }

    @PostMapping
    fun create(@RequestBody newOrderDTO: NewOrderDTO): ResponseEntity<OrderDTO> {
        val orderDTO = orderService.create(newOrderDTO)
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO)
    }

    @PutMapping("/{id}/status/{status}")
    fun update(
        @PathVariable id: Long,
        @PathVariable status: String
    ): ResponseEntity<OrderDTO> {
        val updatedOrderDTO = orderService.update(id, status)
        return ResponseEntity.ok(updatedOrderDTO)
    }
}