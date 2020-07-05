package br.com.runnt.configuration.rest

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.DefaultHeaders

fun Application.installDefaultHeaders() = install(DefaultHeaders) {
    header("X-Engine", "Ktor") // will send this header with each response
}