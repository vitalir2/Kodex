package io.vitalir.kodex.data.figma

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.nulls.shouldNotBeNull
import io.vitalir.kodex.data.figma.network.GetFileRequest
import io.vitalir.kodex.data.figma.network.GetFileResponse
import io.vitalir.kodex.data.figma.network.common.NetworkDataSource
import io.vitalir.kodex.data.figma.network.common.execute
import io.vitalir.kodex.data.figma.network.extension.createFigmaExportHttpClient

// TODO @vitalir: Get some variables from system env
class FigmaDataSourceTest : StringSpec() {
    init {
        "should get not error response" {
            val figmaToken = ""
            val fileKey = ""
            check(figmaToken.isNotBlank()) { "You should set figma token" }
            check(fileKey.isNotBlank()) { "You should set file key" }
            val figmaDataSource = NetworkDataSource(
                client = createFigmaExportHttpClient(figmaToken),
            )
            val response = figmaDataSource.execute<GetFileResponse>(
                GetFileRequest(
                    fileId = fileKey,
                    nodeIds = emptyList()
                )
            )
            response.isSuccess.shouldBeTrue()
            response.getOrNull().shouldNotBeNull()
        }
    }
}
