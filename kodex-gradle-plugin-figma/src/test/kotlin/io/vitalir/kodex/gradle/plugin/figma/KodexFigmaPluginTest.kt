package io.vitalir.kodex.gradle.plugin.figma

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.vitalir.kodex.gradle.plugin.figma.extension.KodexFigmaPluginExtension
import org.gradle.testfixtures.ProjectBuilder

class KodexFigmaPluginTest : StringSpec() {

    init {
        "applying plugin id should enable it" {
            val project = ProjectBuilder.builder().build()
            project.pluginManager.apply("io.vitalir.kodex.figma")

            project.plugins.getPlugin(KodexFigmaPlugin::class.java).shouldNotBeNull()
        }

        "the plugin extension should exist" {
            val project = ProjectBuilder.builder().build()
            project.pluginManager.apply("io.vitalir.kodex.figma")

            val pluginExtension = project.extensions
                .getByName(KodexFigmaPlugin.EXTENSION_NAME) as? KodexFigmaPluginExtension
            pluginExtension.shouldNotBeNull()
        }
    }
}
