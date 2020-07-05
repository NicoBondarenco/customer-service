package br.com.runnt.port.api.rest

import br.com.runnt.port.service.customer.ContactTypeService
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import org.koin.java.KoinJavaComponent.inject

val contactTypeService by inject(ContactTypeService::class.java)

fun Route.contactTypeController(): Route = route("/contact-types") {

    get("/") {
        call.respond(contactTypeService.all())
    }

}