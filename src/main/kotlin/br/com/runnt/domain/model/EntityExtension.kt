package br.com.runnt.domain.model

import br.com.runnt.domain.model.entity.customer.ContactType
import br.com.runnt.domain.model.entity.customer.Gender
import br.com.runnt.domain.model.entity.location.City
import br.com.runnt.domain.model.entity.location.State
import br.com.runnt.domain.model.response.customer.ContactTypeResponse
import br.com.runnt.domain.model.response.customer.GenderResponse
import br.com.runnt.domain.model.response.location.CityResponse
import br.com.runnt.domain.model.response.location.StateResponse

fun ContactType.toResponse() = ContactTypeResponse(
    this.id.value,
    this.name
)

fun Gender.toResponse() = GenderResponse(
    this.id.value,
    this.name,
    this.description
)

fun State.toResponse(withCities: Boolean): StateResponse {

    val cities: List<CityResponse>? = if (withCities) this.cities.map { it.toResponse() } else null

    return StateResponse(
        this.id.value,
        this.name,
        this.acronym,
        cities
    )
}

fun City.toResponse() = CityResponse(
    this.id.value,
    this.name
)

fun City.toFullResponse() = CityResponse(
    this.id.value,
    this.name,
    this.latitude,
    this.longitude
)