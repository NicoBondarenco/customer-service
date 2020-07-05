package br.com.runnt.domain.exception

class UnprocessableEntityException(
    message: String,
    var errors: Map<String, String>
) : RuntimeException(message)