package br.com.runnt.configuration.database

import com.typesafe.config.ConfigFactory
import com.zaxxer.hikari.HikariConfig
import io.ktor.config.ApplicationConfig
import io.ktor.config.HoconApplicationConfig
import java.util.concurrent.TimeUnit

class DatabaseProperties {

    val configuration: ApplicationConfig = HoconApplicationConfig(ConfigFactory.load()).config("database")
    val driver: String = ""
    val url: String = ""
    val username: String = ""
    val password: String = ""
    val maximumPoolSize = 3
    val isAutoCommit = false
    val transactionIsolation: String = "TRANSACTION_REPEATABLE_READ"
    val minIdle = 3
    val connectionTimeout = TimeUnit.SECONDS.toMillis(60)
    val validationTimeout = TimeUnit.SECONDS.toMillis(5)
    val idleTimeout = TimeUnit.MINUTES.toMillis(10)
    val maxLifetime = TimeUnit.MINUTES.toMillis(30)
    val initializationFailTimeout = 1L

    fun hikariConfiguration(): HikariConfig {
        val hikariConfiguration = HikariConfig()

        hikariConfiguration.driverClassName =
            configuration.propertyOrNull("driver")?.getString()
                ?: driver

        hikariConfiguration.jdbcUrl =
            configuration.propertyOrNull("url")?.getString()
                ?: url

        hikariConfiguration.username =
            configuration.propertyOrNull("user")?.getString()
                ?: username

        hikariConfiguration.password =
            configuration.propertyOrNull("password")?.getString()
                ?: password

        hikariConfiguration.maximumPoolSize =
            configuration.propertyOrNull("maximumPoolSize")?.getString()?.toInt()
                ?: maximumPoolSize

        hikariConfiguration.isAutoCommit =
            configuration.propertyOrNull("isAutoCommit")?.getString()?.toBoolean()
                ?: isAutoCommit

        hikariConfiguration.transactionIsolation =
            configuration.propertyOrNull("transactionIsolation")?.getString()
                ?: transactionIsolation

        hikariConfiguration.minimumIdle =
            configuration.propertyOrNull("minimumIdle")?.getString()?.toInt()
                ?: minIdle

        hikariConfiguration.connectionTimeout =
            configuration.propertyOrNull("connectionTimeout")?.getString()?.toLong()
                ?: connectionTimeout

        hikariConfiguration.validationTimeout =
            configuration.propertyOrNull("validationTimeout")?.getString()?.toLong()
                ?: validationTimeout

        hikariConfiguration.idleTimeout =
            configuration.propertyOrNull("idleTimeout")?.getString()?.toLong()
                ?: idleTimeout

        hikariConfiguration.maxLifetime =
            configuration.propertyOrNull("maxLifetime")?.getString()?.toLong()
                ?: maxLifetime

        hikariConfiguration.initializationFailTimeout =
            configuration.propertyOrNull("initializationFailTimeout")?.getString()?.toLong()
                ?: initializationFailTimeout

        return hikariConfiguration
    }

}