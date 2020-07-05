package br.com.runnt.configuration.database

import io.ktor.application.Application
import io.ktor.application.install

fun Application.installExposed() = this.install(Exposed)

fun Application.installFlyway() = this.install(FlywayIntegration)

fun Application.installDatabase() {
    this.installFlyway()
    this.installExposed()
}

