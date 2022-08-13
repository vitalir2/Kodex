@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-gradle-plugin`
    kotlin("jvm")
}

group = "io.vitalir"
version = "0.0.1-alpha"

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
    implementation(project(":kodex-data-figma"))
    implementation(libs.kotlinx.coroutines.core)
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
