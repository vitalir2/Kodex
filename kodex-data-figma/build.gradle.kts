@file:Suppress("UnstableApiUsage")

plugins {
    kotlin("multiplatform")
    kotlin(libs.plugins.kotlinx.serialization.get().pluginId)
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
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

tasks.register<Wrapper>("wrapper") {

}

tasks.register("prepareKotlinBuildScriptModel") {}
