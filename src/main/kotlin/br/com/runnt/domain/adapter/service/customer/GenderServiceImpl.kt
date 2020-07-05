package br.com.runnt.domain.adapter.service.customer

import br.com.runnt.domain.model.entity.customer.Gender
import br.com.runnt.domain.model.response.customer.GenderResponse
import br.com.runnt.domain.model.toResponse
import br.com.runnt.port.service.customer.GenderService
import org.jetbrains.exposed.sql.transactions.transaction


class GenderServiceImpl : GenderService {

    override fun all(): List<GenderResponse> {
        return transaction {
            Gender.all()
                .map { it.toResponse() }
                .toList()
        }
    }

}