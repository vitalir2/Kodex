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
    object Kotlinx {
        const val serialization = "kotlinx-serialization"
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version(VersionNames.kotlin, "1.7.10")
            version(VersionNames.Kotlinx.serialization, "1.4.0-RC")

            alias("kotlinx-serialization").toPluginId("plugin.serialization")
                .versionRef(VersionNames.kotlin)

            alias("kotlinx-serialization-json").to("org.jetbrains.kotlinx", "kotlinx-serialization-json")
                .versionRef(VersionNames.Kotlinx.serialization)
        }
    }
}
