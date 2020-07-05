package br.com.runnt.configuration.rest

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod

fun Application.installCORS() = install(CORS) {
    method(HttpMethod.Options)
    method(HttpMethod.Put)
    method(HttpMethod.Delete)
    method(HttpMethod.Patch)
    header(HttpHeaders.Authorization)
    allowCredentials = true
    anyHost() // @TODO: Don't do this in production if possible. Try to limit it.
}