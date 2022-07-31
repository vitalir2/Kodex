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
        val commonMain by getting {
            dependencies {
                api(project(":kodex-data-api"))
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
