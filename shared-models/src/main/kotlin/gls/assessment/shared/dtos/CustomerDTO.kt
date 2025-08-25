package gls.assessment.shared.dtos

import gls.assessment.shared.entities.customers.Customer

class CustomerDTO(
    var id: Long?,
    var name: String,
    var surname: String,
    var email: String,
    var uuid: String?
) {
    constructor(customerEntity: Customer) : this(
        customerEntity.id,
        customerEntity.name,
        customerEntity.surname,
        customerEntity.email,
        customerEntity.uuid.toString()
    )
}