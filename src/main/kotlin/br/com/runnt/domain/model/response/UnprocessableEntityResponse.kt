package br.com.runnt.domain.model.response

class UnprocessableEntityResponse(
    val message: String,
    val errors: Map<String, String>
)
