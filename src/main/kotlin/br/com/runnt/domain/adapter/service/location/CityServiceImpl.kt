package br.com.runnt.domain.adapter.service.location

import br.com.runnt.configuration.extension.ilike
import br.com.runnt.domain.adapter.repository.location.CityRepository
import br.com.runnt.domain.adapter.repository.location.StateRepository
import br.com.runnt.domain.exception.ResourceNotFoundException
import br.com.runnt.domain.model.entity.location.City
import br.com.runnt.domain.model.response.location.CityResponse
import br.com.runnt.domain.model.toFullResponse
import br.com.runnt.port.service.location.CityService
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.Optional.ofNullable
import java.util.UUID


class CityServiceImpl : CityService {

    override fun findByStateAcronymAndCityNameLike(acronym: String?, cityName: String?): List<CityResponse> {
        return transaction {
            (CityRepository innerJoin StateRepository)
                .slice(CityRepository.columns)
                .select {
                    (StateRepository.acronym eq (acronym ?: "").toUpperCase()) and
                            (CityRepository.name ilike "%${(cityName ?: "")}%")//TODO implementar ilike postgres
                }.map { row -> City.wrapRow(row).toFullResponse() }
        }
    }

    override fun one(cityId: UUID?): CityResponse {
        return transaction {
            ofNullable(City.findById(cityId ?: UUID.randomUUID()))
                .map { it.toFullResponse() }
                .orElseThrow { throw ResourceNotFoundException("City not found for id '${cityId}'") }
        }
    }

}