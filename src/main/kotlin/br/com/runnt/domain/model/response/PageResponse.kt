package br.com.runnt.domain.model.response

import br.com.runnt.domain.model.BaseResponse

data class PageResponse<T: BaseResponse>(
    val content: List<T>,
    val totalElements: Long,
    val pageNumber: Int,
    val pageSize: Int,
    val totalPages: Int,
    val sortField: String,
    val sortDirection: String
)