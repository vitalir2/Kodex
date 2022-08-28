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
        val commonMain by getting {
            dependencies {
                api(project(":kodex-core"))
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
