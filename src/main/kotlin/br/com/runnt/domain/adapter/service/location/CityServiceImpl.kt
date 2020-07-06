package br.com.runnt.domain.adapter.service.location

import br.com.runnt.configuration.extension.*
import br.com.runnt.domain.adapter.repository.location.CityRepository
import br.com.runnt.domain.adapter.repository.location.StateRepository
import br.com.runnt.domain.exception.ResourceNotFoundException
import br.com.runnt.domain.model.entity.location.City
import br.com.runnt.domain.model.request.PageRequest
import br.com.runnt.domain.model.response.PageResponse
import br.com.runnt.domain.model.response.location.CityResponse
import br.com.runnt.domain.model.toFullResponse
import br.com.runnt.port.service.location.CityService
import org.jetbrains.exposed.sql.alias
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.Optional.ofNullable
import java.util.UUID


class CityServiceImpl : CityService {

    override fun findByStateAcronymAndCityNameLike(acronym: String?, cityName: String?, pageRequest: PageRequest): PageResponse<CityResponse> {
        val totalColumn = CityRepository.id.countOver().alias("total")//Alway put an alias

        val pageResponse = transaction {
            (CityRepository innerJoin StateRepository)
                .slice(CityRepository.columns + totalColumn)
                .select {
                    (StateRepository.acronym eq (acronym ?: "").toUpperCase()) and
                            (CityRepository.name ilike "%${(cityName ?: "")}%")
                }
                .orderByIfNotNull(pageRequest.sortColumn(CityRepository), pageRequest.sortOrder())
                .limit(pageRequest)
                .page(totalColumn, pageRequest) { row -> City.wrapRow(row).toFullResponse() }
        }

        return pageResponse
    }

    override fun one(cityId: UUID?): CityResponse {
        return transaction {
            ofNullable(City.findById(cityId ?: UUID.randomUUID()))
                .map { it.toFullResponse() }
                .orElseThrow { throw ResourceNotFoundException("City not found for id '${cityId}'") }
        }
    }

}