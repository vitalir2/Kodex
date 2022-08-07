@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-gradle-plugin`
    kotlin("jvm")
}

group = "me.vitalir"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

gradlePlugin {
    plugins {
        create("kodex-figma") {
            id = "io.vitalir.kodex.figma"
            implementationClass = "io.vitalir.kodex.gradle.plugin.figma.FigmaKodexPlugin"
        }
    }
}

dependencies {
    implementation(project(":kodex-data-figma"))
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
