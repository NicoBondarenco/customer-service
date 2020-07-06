package br.com.runnt.configuration.extension

import br.com.runnt.domain.model.request.PageRequest
import io.ktor.request.ApplicationRequest

fun ApplicationRequest.pageRequest() = PageRequest(
    pageNumber = (this.queryParameters["p"] ?: "0").toInt(),
    pageSize = (this.queryParameters["s"] ?: "10").toInt(),
    sortField = this.queryParameters["f"],
    sortDirection = this.queryParameters["d"]
)