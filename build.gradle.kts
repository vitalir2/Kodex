@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("jvm") version libs.versions.kotlin apply false
    kotlin("multiplatform") version libs.versions.kotlin apply false
}

group = "io.vitalir"
version = "0.0.1-alpha"

repositories {
    mavenCentral()
}
