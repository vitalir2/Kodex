package io.vitalir.kodex.data.figma

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.nulls.shouldNotBeNull
import io.vitalir.kodex.core.common.getEnv
import io.vitalir.kodex.data.figma.network.GetFileNodesRequest
import io.vitalir.kodex.data.figma.network.GetFileNodesResponse
import io.vitalir.kodex.data.figma.network.GetFileStylesRequest
import io.vitalir.kodex.data.figma.network.GetFileStylesResponse
import io.vitalir.kodex.data.figma.network.common.NetworkDataSource
import io.vitalir.kodex.data.figma.network.common.execute
import io.vitalir.kodex.data.figma.network.extension.createFigmaExportHttpClient

class FigmaDataSourceTest : StringSpec() {

    private val figmaTestData = getValidatedFigmaTestData()

    private val figmaDataSource = NetworkDataSource(
        client = createFigmaExportHttpClient(figmaTestData.figmaToken),
    )
    init {
        "should get successful response when will get nodes by a valid file key" {
            val response = figmaDataSource.execute<GetFileNodesResponse>(
                GetFileNodesRequest(
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
    val figmaToken = getEnv("FIGMA_TOKEN")
    val figmaFileKey = getEnv("FIGMA_FILE_KEY")
    check(figmaToken != null) { "You should set figma token" }
    check(figmaFileKey != null) { "You should set file key" }
    return FigmaNetworkTestData(
        figmaToken = figmaToken,
        fileKey = figmaFileKey,
    )
}

private data class FigmaNetworkTestData(
    val figmaToken: String,
    val fileKey: String,
)
