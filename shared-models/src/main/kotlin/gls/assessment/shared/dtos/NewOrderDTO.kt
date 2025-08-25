package gls.assessment.shared.dtos

class NewOrderDTO(
    val customerUUID: String,
    val description: String,
    val items: Set<String>
)