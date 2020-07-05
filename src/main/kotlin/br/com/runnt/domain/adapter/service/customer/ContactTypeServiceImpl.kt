package br.com.runnt.domain.adapter.service.customer

import br.com.runnt.domain.model.entity.customer.ContactType
import br.com.runnt.domain.model.response.customer.ContactTypeResponse
import br.com.runnt.domain.model.toResponse
import br.com.runnt.port.service.customer.ContactTypeService
import org.jetbrains.exposed.sql.transactions.transaction


class ContactTypeServiceImpl : ContactTypeService {

    override fun all(): List<ContactTypeResponse> {
        return transaction {
            ContactType.all()
                .map { it.toResponse() }
                .toList()
        }
    }

}