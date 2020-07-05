package br.com.runnt.configuration.database

import io.ktor.application.ApplicationCallPipeline
import io.ktor.application.ApplicationFeature
import io.ktor.util.AttributeKey
import org.flywaydb.core.Flyway

class FlywayIntegration(configuration: DatabaseProperties) {

    init {
        val flyway = Flyway.configure()
            .dataSource(
                configuration.configuration.propertyOrNull("url")?.getString() ?: configuration.url,
                configuration.configuration.propertyOrNull("user")?.getString() ?: configuration.username,
                configuration.configuration.propertyOrNull("password")?.getString() ?: configuration.password
            )
            .locations("migration")
            .load()
        flyway.migrate()
    }

    companion object Feature : ApplicationFeature<ApplicationCallPipeline, DatabaseProperties, FlywayIntegration> {

        override val key: AttributeKey<FlywayIntegration> = AttributeKey("database")

        override fun install(
            pipeline: ApplicationCallPipeline,
            configure: DatabaseProperties.() -> Unit
        ): FlywayIntegration {
            val databaseInit = FlywayIntegration(DatabaseProperties().apply(configure))
            return databaseInit
        }
    }
}