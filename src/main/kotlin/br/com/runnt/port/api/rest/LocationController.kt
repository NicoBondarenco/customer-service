package br.com.runnt.port.api.rest

import br.com.runnt.configuration.extension.toUUID
import br.com.runnt.port.service.location.CityService
import br.com.runnt.port.service.location.StateService
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.route
import org.koin.java.KoinJavaComponent.inject
import java.util.Optional.ofNullable

val stateService by inject(StateService::class.java)
val cityService by inject(CityService::class.java)

fun Route.locationController(): Route = route("/location") {

    route("/states") {

        get("/") {
            val withCities: Boolean = ofNullable(call.request.queryParameters["withCities"])
                .map { v -> v.toBoolean() }
                .orElse(false)
            call.respond(stateService.all(withCities))
        }

        route("/{acronym}") {

            get("/") {
                val acronym = call.parameters["acronym"]
                call.respond(stateService.findByAcronym(acronym))
            }

            route("/cities") {

                get("/{cityName}") {
                    val acronym = call.parameters["acronym"]
                    val cityName = call.parameters["cityName"]
                    call.respond(cityService.findByStateAcronymAndCityNameLike(acronym, cityName))
                }

                get("/") {
                    val cityId = call.request.queryParameters["cityId"]?.toUUID()
                    call.respond(cityService.one(cityId))
                }

            }

        }
    }

}