package br.com.runnt.domain.adapter.service.location

import br.com.runnt.domain.adapter.repository.location.StateRepository
import br.com.runnt.domain.exception.ResourceNotFoundException
import br.com.runnt.domain.model.entity.location.State
import br.com.runnt.domain.model.response.location.StateResponse
import br.com.runnt.domain.model.toResponse
import br.com.runnt.port.service.location.StateService
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.Optional.ofNullable


class StateServiceImpl : StateService {

    override fun all(withCities: Boolean): List<StateResponse> {
        return transaction {
            State.all().map {
                it.toResponse(withCities)
            }
        }
    }

    override fun findByAcronym(acronym: String?): StateResponse {
        return transaction {
            ofNullable(State.find { StateRepository.acronym eq (acronym ?: "").toUpperCase() }.firstOrNull())
                .map { it.toResponse(true) }
                .orElseThrow { throw ResourceNotFoundException("State not found with acronym '$acronym'") }
        }
    }

}