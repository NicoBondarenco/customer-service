package br.com.runnt.port.api.rest

import br.com.runnt.port.service.customer.GenderService
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import org.koin.java.KoinJavaComponent.inject

val genderService by inject(GenderService::class.java)

fun Route.genderController(): Route = route("/genders") {

    get("/") {
        call.respond(genderService.all())
    }

}