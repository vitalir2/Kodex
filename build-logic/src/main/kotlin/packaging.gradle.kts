import org.gradle.kotlin.dsl.repositories

group = "io.vitalir"
version = "0.0.1-alpha"

plugins {
    `maven-publish`
}

publishing {
    repositories {
        maven {
            url = uri("../artifacts")
        }
    }
}
