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

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("kotlin", "1.7.10")
            version("kotlinx-serialization", "1.4.0-RC")
        }
    }
}
