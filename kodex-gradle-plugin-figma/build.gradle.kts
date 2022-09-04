@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-gradle-plugin`
    kotlin("jvm")
    kotlin(libs.plugins.kotlinx.serialization.get().pluginId)
    id(libs.plugins.kotest.plugin.get().pluginId)
    id("packaging")
}

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("kodex-figma") {
            id = "io.vitalir.kodex.figma"
            implementationClass = "io.vitalir.kodex.gradle.plugin.figma.KodexFigmaPlugin"
        }
    }
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.napier)
    testImplementation(libs.kotest.runner.jvm)
    testImplementation(libs.kotest.framework)
    testImplementation(libs.kotest.assertions)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
