package io.vitalir.kodex.data.figma.repository

import io.vitalir.kodex.core.models.Color
import io.vitalir.kodex.data.api.ResourceRepository
import io.vitalir.kodex.data.figma.network.FrameNode
import io.vitalir.kodex.data.figma.network.GetFileNodesRequest
import io.vitalir.kodex.data.figma.network.GetFileNodesResponse
import io.vitalir.kodex.data.figma.network.GetFileStylesRequest
import io.vitalir.kodex.data.figma.network.GetFileStylesResponse
import io.vitalir.kodex.data.figma.network.Node
import io.vitalir.kodex.data.figma.network.Style
import io.vitalir.kodex.data.figma.network.common.NetworkDataSource
import io.vitalir.kodex.data.figma.network.common.execute

class FigmaColorRepository(
    private val figmaDataSource: NetworkDataSource
) : ResourceRepository<String, Color> {

    // TODO @vitalir: Fix params type
    override suspend fun fetchResource(params: String): List<Color> {
        val styles = getFileStyles(params) ?: error("Cannot get file with key=$params") // TODO @vitalir: Add more helpful error messages
        val styleNodes = getNodes(params, styles.map(Style::nodeId)) ?: return emptyList()
        return styles.mapNotNull { style ->
            val node = styleNodes.getOrDefault(style.nodeId, null) ?: return@mapNotNull null
            val colorFill = (node as? FrameNode)?.fills?.firstOrNull()?.color ?: return@mapNotNull null
            Color(
                name = node.name,
                red = colorFill.r,
                green = colorFill.g,
                blue = colorFill.b,
                alpha = colorFill.a,
            )
        }
    }

    private suspend fun getFileStyles(fileKey: String): List<Style>? {
        val response = figmaDataSource.execute<GetFileStylesResponse>(GetFileStylesRequest(fileKey))
        return response.getOrNull()?.meta?.styles
    }

    private suspend fun getNodes(fileKey: String, nodeIds: List<String>): Map<String, Node>? {
        val response = figmaDataSource.execute<GetFileNodesResponse>(
            GetFileNodesRequest(
                fileKey = fileKey,
                nodeIds = nodeIds,
            )
        )
        return response.getOrNull()?.nodes
    }
}
