package io.vitalir.kodex.gradle.plugin.figma

import io.vitalir.kodex.gradle.plugin.figma.extension.KodexFigmaPluginExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class KodexFigmaPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        val extension = target.extensions.create(
            EXTENSION_NAME,
            KodexFigmaPluginExtension::class.java,
        )
        println("Hello user with token=${extension.figmaToken}")
    }

    companion object {
        internal const val EXTENSION_NAME = "kodex-figma"
    }
}
