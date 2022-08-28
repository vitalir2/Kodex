package io.vitalir.kodex.gradle.plugin.figma

import io.vitalir.kodex.core.models.Color
import io.vitalir.kodex.data.api.ResourceRepository
import io.vitalir.kodex.data.figma.network.common.NetworkDataSource
import io.vitalir.kodex.data.figma.network.extension.createFigmaExportHttpClient
import io.vitalir.kodex.data.figma.repository.FigmaColorRepository
import io.vitalir.kodex.gradle.plugin.figma.extension.KodexFigmaPluginExtension
import io.vitalir.kodex.gradle.plugin.figma.task.ExportColors
import org.gradle.api.Plugin
import org.gradle.api.Project

class KodexFigmaPlugin : Plugin<Project> {

    private lateinit var figmaColorRepository: ResourceRepository<String, Color>

    override fun apply(target: Project) {
        val extension = target.extensions.create(
            EXTENSION_NAME,
            KodexFigmaPluginExtension::class.java,
        )
        figmaColorRepository = FigmaColorRepository(
            figmaDataSource = NetworkDataSource(
                createFigmaExportHttpClient(extension.figmaToken.orEmpty())
            )
        )
        target.tasks.register("kodexFigmaExportColors", ExportColors::class.java) { task ->
            task.colorRepository = figmaColorRepository
            task.lightFileId.set(extension.lightFileId)
        }
    }

    companion object {
        internal const val EXTENSION_NAME = "kodexFigma"
    }
}
