package gls.assessment.orders.proxy

import gls.assessment.shared.dtos.CustomerDTO

interface CustomerProxy {
    fun getByUUID(uuid: String): CustomerDTO
    fun getById(id: Long): CustomerDTO
}