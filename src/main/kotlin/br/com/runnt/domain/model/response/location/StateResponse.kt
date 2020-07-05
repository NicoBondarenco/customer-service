package br.com.runnt.domain.model.response.location

import br.com.runnt.domain.model.BaseResponse
import java.util.UUID

data class StateResponse(
    val id: UUID,
    val name: String,
    val acronym: String,
    val cities: List<CityResponse>? = null
) : BaseResponse()