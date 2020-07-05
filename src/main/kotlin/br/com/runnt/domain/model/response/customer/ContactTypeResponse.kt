package br.com.runnt.domain.model.response.customer

import br.com.runnt.domain.model.BaseResponse
import java.util.UUID

data class ContactTypeResponse(
    val id: UUID,
    val name: String
) : BaseResponse()