package br.com.runnt.port.service.location

import br.com.runnt.domain.model.request.PageRequest
import br.com.runnt.domain.model.request.PageRequest.Companion.of
import br.com.runnt.domain.model.response.PageResponse
import br.com.runnt.domain.model.response.location.CityResponse
import java.util.UUID

interface CityService {

    fun findByStateAcronymAndCityNameLike(acronym: String?, cityName: String?, pageRequest: PageRequest = of()): PageResponse<CityResponse>
    fun one(cityId: UUID?): CityResponse

}