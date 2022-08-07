package io.vitalir.kodex.data.figma.network

import kotlinx.serialization.Serializable

@Serializable
internal data class GetFileNodesResponse(
    val nodes: Map<String, Node>,
)
