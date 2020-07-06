package br.com.runnt.domain.model.response.exception

class UnprocessableEntityResponse(
    val message: String,
    val errors: Map<String, String>
)
