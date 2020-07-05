package br.com.runnt.configuration.rest

import br.com.runnt.configuration.extension.notFound
import br.com.runnt.configuration.extension.unprocessableEntity
import br.com.runnt.domain.exception.ResourceNotFoundException
import br.com.runnt.domain.exception.UnprocessableEntityException
import br.com.runnt.domain.model.response.ResourceNotFoundResponse
import br.com.runnt.domain.model.response.UnprocessableEntityResponse
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.StatusPages

fun Application.installStatusPages() = install(StatusPages) {
    exception<ResourceNotFoundException> { cause ->
        call.notFound(ResourceNotFoundResponse(cause.message ?: "Resource not found"))
    }
    exception<UnprocessableEntityException> { cause ->
        call.unprocessableEntity(UnprocessableEntityResponse(cause.message ?: "Error processing entity", cause.errors))
    }
}