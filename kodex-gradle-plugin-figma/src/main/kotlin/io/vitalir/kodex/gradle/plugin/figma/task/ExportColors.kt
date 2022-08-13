package io.vitalir.kodex.gradle.plugin.figma.task

import io.vitalir.kodex.core.models.Color
import io.vitalir.kodex.data.api.ResourceRepository
import kotlinx.coroutines.runBlocking
import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.TaskAction

abstract class ExportColors : DefaultTask() {

    abstract val lightFileId: Property<String>

    lateinit var colorRepository: ResourceRepository<String, Color>

    @TaskAction
    fun export() {
        val colors = runBlocking { colorRepository.fetchResource(lightFileId.get().orEmpty()) }
        println("Fetched colors=$colors")
    }
}
