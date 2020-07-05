package br.com.runnt.domain.model.response.location

import br.com.runnt.domain.model.BaseResponse
import java.math.BigDecimal
import java.util.UUID


data class CityResponse(
    val id: UUID,
    val name: String,
    val latitude: BigDecimal? = null,
    val longitude: BigDecimal? = null
) : BaseResponse()