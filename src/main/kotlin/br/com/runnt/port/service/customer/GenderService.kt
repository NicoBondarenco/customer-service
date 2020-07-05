package br.com.runnt.port.service.customer

import br.com.runnt.domain.model.response.customer.GenderResponse

interface GenderService {

    fun all(): List<GenderResponse>

}