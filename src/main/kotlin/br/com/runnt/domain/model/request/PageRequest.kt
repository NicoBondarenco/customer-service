package br.com.runnt.domain.model.request

import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.SortOrder

data class PageRequest(
    val pageNumber: Int,
    val pageSize: Int,
    val sortField: String? = null,
    val sortDirection: String? = null
) {
    companion object {
        fun of(
            pageNumber: Int = 0,
            pageSize: Int = 10,
            sortField: String? = null,
            sortDirection: String? = null
        ): PageRequest {
            return PageRequest(pageNumber, pageSize, sortField, sortDirection)
        }
    }

    fun sortColumn(table: IdTable<*>): Column<*>? {
        return table.columns.firstOrNull { it.name.equals(sortField) }
    }

    fun sortOrder(): SortOrder {
        return SortOrder.values().firstOrNull { value -> value.name.equals(sortDirection) } ?: SortOrder.ASC
    }
}