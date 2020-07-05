package br.com.runnt

import br.com.runnt.configuration.database.installDatabase
import br.com.runnt.configuration.json.installJackson
import br.com.runnt.configuration.koin.installKoin
import br.com.runnt.configuration.logging.installCallLogging
import br.com.runnt.configuration.rest.installCORS
import br.com.runnt.configuration.rest.installDefaultHeaders
import br.com.runnt.configuration.rest.installStatusPages
import br.com.runnt.port.api.rest.contactTypeController
import br.com.runnt.port.api.rest.genderController
import br.com.runnt.port.api.rest.locationController
import io.ktor.application.Application
import io.ktor.routing.route
import io.ktor.routing.routing
import io.ktor.server.netty.EngineMain

fun main(args: Array<String>): Unit = EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    configure()
    registerRoutes()
}

fun Application.registerRoutes() {
    routing {
        route("/api") {
            contactTypeController()
            genderController()
            locationController()
        }
    }
}

fun Application.configure() {
    installDatabase()
    installKoin()
    installCallLogging()
    installCORS()
    installDefaultHeaders()
    installJackson()
    installStatusPages()
}