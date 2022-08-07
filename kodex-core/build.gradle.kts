plugins {
    kotlin("multiplatform")
}

group = "io.vitalir"

repositories {
    mavenCentral()
}

kotlin {
    jvm()
    sourceSets {
        val commonMain by getting
        val commonTest by getting
    }
}

tasks.register<Wrapper>("wrapper") {

}

tasks.register("prepareKotlinBuildScriptModel") {}
