package br.com.runnt.port.service.location

import br.com.runnt.domain.model.response.location.CityResponse
import java.util.UUID

interface CityService {

    fun findByStateAcronymAndCityNameLike(acronym: String?, cityName: String?): List<CityResponse>
    fun one(cityId: UUID?): CityResponse

}