package br.com.runnt.port.service.location

import br.com.runnt.domain.model.response.location.StateResponse

interface StateService {

    fun all(withCities: Boolean): List<StateResponse>

    fun findByAcronym(acronym: String?): StateResponse

}