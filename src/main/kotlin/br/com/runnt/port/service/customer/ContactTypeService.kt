package br.com.runnt.port.service.customer

import br.com.runnt.domain.model.response.customer.ContactTypeResponse

interface ContactTypeService {

    fun all(): List<ContactTypeResponse>

}