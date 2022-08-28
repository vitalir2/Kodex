plugins {
    kotlin("multiplatform")
    id("packaging")
}

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
