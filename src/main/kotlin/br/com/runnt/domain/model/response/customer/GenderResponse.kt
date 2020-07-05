package br.com.runnt.domain.model.response.customer

import br.com.runnt.domain.model.BaseResponse
import java.util.UUID

data class GenderResponse(
    val id: UUID,
    val name: String,
    val description: String
) : BaseResponse()