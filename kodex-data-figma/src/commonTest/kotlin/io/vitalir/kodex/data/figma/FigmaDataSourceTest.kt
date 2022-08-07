package io.vitalir.kodex.data.figma

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.nulls.shouldNotBeNull
import io.vitalir.kodex.data.figma.network.GetFileRequest
import io.vitalir.kodex.data.figma.network.GetFileResponse
import io.vitalir.kodex.data.figma.network.GetFileStylesRequest
import io.vitalir.kodex.data.figma.network.GetFileStylesResponse
import io.vitalir.kodex.data.figma.network.common.NetworkDataSource
import io.vitalir.kodex.data.figma.network.common.execute
import io.vitalir.kodex.data.figma.network.extension.createFigmaExportHttpClient

// TODO @vitalir: Get some variables from system env
class FigmaDataSourceTest : StringSpec() {

    private val figmaTestData = getValidatedFigmaTestData()

    private val figmaDataSource = NetworkDataSource(
        client = createFigmaExportHttpClient(figmaTestData.figmaToken),
    )
    init {
        "should get successful response when will get nodes by a valid file key" {
            val response = figmaDataSource.execute<GetFileResponse>(
                GetFileRequest(
                    fileKey = figmaTestData.fileKey,
                    nodeIds = emptyList()
                )
            )
            response.shouldBeSuccessful()
        }

        "should get successful response when will get file styles by file key" {
            val response = figmaDataSource.execute<GetFileStylesResponse>(
                GetFileStylesRequest(
                    fileKey = figmaTestData.fileKey,
                )
            )
            response.shouldBeSuccessful()

        }
    }
}

private fun Result<*>.shouldBeSuccessful() {
    isSuccess.shouldBeTrue()
    getOrNull().shouldNotBeNull()
}

private fun getValidatedFigmaTestData(): FigmaNetworkTestData {
    check(FIGMA_TOKEN.isNotBlank()) { "You should set figma token" }
    check(FIGMA_FILE_KEY.isNotBlank()) { "You should set file key" }
    return FigmaNetworkTestData(
            figmaToken = FIGMA_TOKEN,
            fileKey = FIGMA_FILE_KEY,
        )
}

private data class FigmaNetworkTestData(
    val figmaToken: String,
    val fileKey: String,
)

private const val FIGMA_TOKEN = ""
private const val FIGMA_FILE_KEY = ""
