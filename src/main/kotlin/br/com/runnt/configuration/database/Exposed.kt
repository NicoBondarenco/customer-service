package br.com.runnt.configuration.database

import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.ApplicationCallPipeline
import io.ktor.application.ApplicationFeature
import io.ktor.util.AttributeKey
import org.jetbrains.exposed.sql.Database

class Exposed(configuration: DatabaseProperties) {

    init {
        val configuration = configuration.hikariConfiguration()
        val datasource = HikariDataSource(configuration)
        Database.connect(datasource)
    }

    companion object Feature : ApplicationFeature<ApplicationCallPipeline, DatabaseProperties, Exposed> {

        override val key: AttributeKey<Exposed> = AttributeKey("database")

        override fun install(pipeline: ApplicationCallPipeline, configure: DatabaseProperties.() -> Unit): Exposed {
            val databaseInit = Exposed(DatabaseProperties().apply(configure))
            return databaseInit
        }
    }
}