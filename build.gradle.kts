plugins {
    application
    kotlin("jvm") version "1.3.72"
}

group = "br.com.runnt"
version = "0.0.1"

val kotlinVersion = "1.3.72"
val ktorVersion = "1.3.2"
val koinVersion = "2.1.6"
val logbackVersion = "1.2.1"
val exposedVersion = "0.26.1"
val hikariVersion = "3.4.5"
val flywayVersion = "6.5.0"
val postgresVersion = "42.2.14"

application {
    mainClassName = "io.ktor.server.netty.EngineMain"
}

kotlin.sourceSets["main"].kotlin.srcDirs("src/main/kotlin")
kotlin.sourceSets["test"].kotlin.srcDirs("src/test/kotlin")

kotlin.sourceSets["main"].resources.srcDirs("src/main/resources")
kotlin.sourceSets["test"].resources.srcDirs("src/test/resources")

repositories {
    mavenLocal()
    jcenter()
    maven { url = uri("https://kotlin.bintray.com/ktor") }
    maven { url = uri("https://dl.bintray.com/kotlin/exposed") }
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
    maven { url = uri("https://dl.bintray.com/kotlin/ktor") }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")

    implementation("ch.qos.logback:logback-classic:$logbackVersion")

    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-core:$ktorVersion")
    implementation("io.ktor:ktor-jackson:$ktorVersion")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.fasterxml.jackson.module:jackson-module-jaxb-annotations:2.10.2")

    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.10.2")

    implementation("org.koin:koin-ktor:$koinVersion")
    implementation("org.koin:koin-logger-slf4j:$koinVersion")

    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-dao:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-java-time:$exposedVersion")

    implementation("com.zaxxer:HikariCP:$hikariVersion")

    implementation("org.flywaydb:flyway-core:$flywayVersion")

    runtimeOnly("org.postgresql:postgresql:$postgresVersion")

    testImplementation("io.ktor:ktor-server-tests:$ktorVersion")
    testImplementation("org.koin:koin-test:$koinVersion")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}