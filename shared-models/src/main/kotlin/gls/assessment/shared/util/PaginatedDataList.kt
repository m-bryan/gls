package gls.assessment.shared.util

import org.springframework.data.domain.Page


class PaginatedDataList<T> {
    var items: List<T>
    var pagination: PaginationDTO

    constructor() : this(emptyList<T>(), PaginationDTO(0, 0, 0))

    constructor(items: List<T>, paginationDTO: PaginationDTO) {
        this.items = items
        this.pagination = paginationDTO
    }

    constructor(page: Page<T>) : this(page.content, PaginationDTO(page.number, page.size, page.totalElements))
}