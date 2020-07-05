package br.com.runnt.configuration.logging

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.request.path
import org.slf4j.event.Level

fun Application.installCallLogging() = install(CallLogging) {
    level = Level.INFO
    filter { call -> call.request.path().startsWith("/") }
}