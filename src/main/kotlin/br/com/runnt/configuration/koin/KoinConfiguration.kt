package br.com.runnt.configuration.koin

import br.com.runnt.domain.adapter.service.customer.ContactTypeServiceImpl
import br.com.runnt.domain.adapter.service.customer.GenderServiceImpl
import br.com.runnt.domain.adapter.service.location.CityServiceImpl
import br.com.runnt.domain.adapter.service.location.StateServiceImpl
import br.com.runnt.port.service.customer.ContactTypeService
import br.com.runnt.port.service.customer.GenderService
import br.com.runnt.port.service.location.CityService
import br.com.runnt.port.service.location.StateService
import io.ktor.application.Application
import io.ktor.application.install
import org.koin.dsl.module
import org.koin.experimental.builder.singleBy
import org.koin.ktor.ext.Koin
import org.koin.logger.slf4jLogger


fun Application.installKoin() = this.install(Koin) {
    this.slf4jLogger()
    modules(
        serviceModule
    )
}

val serviceModule = module(createdAtStart = true) {
    singleBy<GenderService, GenderServiceImpl>()
    singleBy<ContactTypeService, ContactTypeServiceImpl>()
    singleBy<StateService, StateServiceImpl>()
    singleBy<CityService, CityServiceImpl>()
//    singleBy<HelloService, HelloServiceImpl>()
//    single<HelloRepository>()
}