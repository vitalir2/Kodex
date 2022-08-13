@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("multiplatform")
    kotlin(libs.plugins.kotlinx.serialization.get().pluginId)
    id(libs.plugins.kotest.plugin.get().pluginId)
}

group = "io.vitalir"

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(project(":kodex-data-api"))
                implementation(libs.kotlinx.serialization.json)
                api(libs.ktor.client.core)
                implementation(libs.ktor.client.cio)
                implementation(libs.ktor.client.content.negotiation)
                implementation(libs.ktor.serialization.kotlinx.json)
                implementation(libs.napier)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotest.framework)
                implementation(libs.kotest.assertions)
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation(libs.kotest.runner.jvm)
            }
        }
    }
}

tasks.register<Wrapper>("wrapper") {

}

tasks.register("prepareKotlinBuildScriptModel") {}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
    filter {
        isFailOnNoMatchingTests = false
    }
    testLogging {
        showExceptions = true
        showStandardStreams = true
        events = setOf(
            org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
            org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
        )
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}
