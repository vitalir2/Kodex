@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("jvm") version libs.versions.kotlin apply false
    kotlin("multiplatform") version libs.versions.kotlin apply false
    kotlin(libs.plugins.kotlinx.serialization.get().pluginId) version libs.versions.kotlin apply false
    id(libs.plugins.kotest.plugin.get().pluginId) version libs.versions.kotest.plugin apply false
    // Android
    kotlin("android") version libs.versions.kotlin apply false
    id("com.android.application") version "7.2.0" apply false
    id("com.android.library") version "7.2.0" apply false
}

group = "io.vitalir"
version = "0.0.1-alpha"

repositories {
    mavenCentral()
    google()
}
