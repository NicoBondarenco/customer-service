package br.com.runnt.configuration.extension

import br.com.runnt.domain.model.BaseResponse
import br.com.runnt.domain.model.request.PageRequest
import br.com.runnt.domain.model.response.PageResponse
import org.jetbrains.exposed.sql.*
import java.math.BigDecimal
import java.math.RoundingMode

fun Query.orderByIfNotNull(column: Expression<*>?, order: SortOrder = SortOrder.ASC): Query {
    if (column == null) {
        return this
    } else {
        return this.orderBy(column = column, order = order)
    }
}

fun Query.limit(pageRequest: PageRequest) = this.limit(pageRequest.pageSize, (pageRequest.pageSize * pageRequest.pageNumber).toLong())

fun <T : BaseResponse> Query.page(totalColumn: ExpressionAlias<Long>, pageRequest: PageRequest, transform: (ResultRow) -> T): PageResponse<T> {
    var total: Long = 0

    val content: List<T> = this.map { row ->
        total = row[totalColumn]
        transform(row)
    }


    return PageResponse(
        content,
        total,
        pageRequest.pageNumber,
        pageRequest.pageSize,
        BigDecimal.valueOf(total).divide(BigDecimal.valueOf(pageRequest.pageSize.toLong()), 0, RoundingMode.CEILING).toInt(),
        pageRequest.sortField ?: "",
        pageRequest.sortDirection.toString()
    )
}