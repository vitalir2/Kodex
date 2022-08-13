package io.vitalir.kodex.gradle.plugin.figma

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.vitalir.kodex.gradle.plugin.figma.extension.KodexFigmaPluginExtension
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

class KodexFigmaPluginTest : StringSpec() {

    init {
        "applying plugin id should enable it" {
            val project = ProjectBuilder.builder().build()
            project.applyKodexFigma()

            project.plugins.getPlugin(KodexFigmaPlugin::class.java).shouldNotBeNull()
        }

        "the plugin extension should exist" {
            val project = ProjectBuilder.builder().build()
            project.applyKodexFigma()

            val pluginExtension = project.extensions
                .getByName(KodexFigmaPlugin.EXTENSION_NAME) as? KodexFigmaPluginExtension
            pluginExtension.shouldNotBeNull()
        }

        "set and get plugin extension fields" {
            val project = ProjectBuilder.builder().build()
            project.applyKodexFigma()

            val pluginExtension = project.extensions
                .getByName(KodexFigmaPlugin.EXTENSION_NAME) as? KodexFigmaPluginExtension

            val lightFileId = "abkekd"
            pluginExtension?.lightFileId.shouldBeNull()
            project.extensions.configure(KodexFigmaPluginExtension::class.java) { extension ->
                extension.lightFileId = lightFileId
            }
            pluginExtension?.lightFileId shouldBe lightFileId
        }
    }

    companion object {
        private fun Project.applyKodexFigma() {
            project.pluginManager.apply("io.vitalir.kodex.figma")
        }
    }
}
