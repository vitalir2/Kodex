@file:Suppress("UnstableApiUsage")

enableFeaturePreview("VERSION_CATALOGS")

rootProject.name = "kodex"

include(":kodex-plugin")
include(":kodex-data-api")
include(":kodex-data-figma")
include(":kodex-gen-api")
include(":kodex-gen-android")
include(":kodex-manager")
include(":kodex-core")

object VersionNames {
    const val kotlin = "kotlin"
    const val ktor = "ktor"
    const val napier = "napier"
    object Kotlinx {
        const val serialization = "kotlinx-serialization"
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version(VersionNames.kotlin, "1.7.10")
            version(VersionNames.Kotlinx.serialization, "1.4.0-RC")
            version(VersionNames.ktor, "2.0.3")
            version(VersionNames.napier, "2.6.1")

            alias("kotlinx-serialization").toPluginId("plugin.serialization")
                .versionRef(VersionNames.kotlin)

            alias("kotlinx-serialization-json").to("org.jetbrains.kotlinx", "kotlinx-serialization-json")
                .versionRef(VersionNames.Kotlinx.serialization)

            alias("ktor-client-core").to("io.ktor", "ktor-client-core")
                .versionRef(VersionNames.ktor)

            alias("ktor-client-cio").to("io.ktor", "ktor-client-cio")
                .versionRef(VersionNames.ktor)

            alias("napier").to("io.github.aakira", "napier")
                .versionRef(VersionNames.napier)
        }
    }
}
