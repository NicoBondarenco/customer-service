package br.com.runnt.configuration.json

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import com.fasterxml.jackson.annotation.PropertyAccessor.ALL
import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_INVALID_SUBTYPE
import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT
import com.fasterxml.jackson.databind.SerializationFeature.WRITE_DATES_AS_TIMESTAMPS
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson

fun Application.installJackson() = install(ContentNegotiation) {
    jackson {
        registerKotlinModule()
        registerModule(JavaTimeModule())
        enable(INDENT_OUTPUT)
        disable(FAIL_ON_UNKNOWN_PROPERTIES)
        disable(FAIL_ON_UNKNOWN_PROPERTIES)
        disable(FAIL_ON_INVALID_SUBTYPE)
        disable(WRITE_DATES_AS_TIMESTAMPS)
        setVisibility(ALL, ANY)
        setSerializationInclusion(NON_NULL)
    }
}