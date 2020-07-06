package br.com.runnt.configuration.extension

import br.com.runnt.domain.model.response.CreatedResponse
import br.com.runnt.domain.model.response.exception.ResourceNotFoundResponse
import br.com.runnt.domain.model.response.exception.UnprocessableEntityResponse
import io.ktor.application.ApplicationCall
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond

suspend inline fun ApplicationCall.ok(response: Any) = this.respond(HttpStatusCode.OK, response)

suspend inline fun ApplicationCall.created(response: CreatedResponse) = this.respond(HttpStatusCode.Created, response)

suspend inline fun ApplicationCall.unprocessableEntity(response: UnprocessableEntityResponse) = this.respond(HttpStatusCode.UnprocessableEntity, response)

suspend inline fun ApplicationCall.notFound(response: ResourceNotFoundResponse) = this.respond(HttpStatusCode.NotFound, response)
