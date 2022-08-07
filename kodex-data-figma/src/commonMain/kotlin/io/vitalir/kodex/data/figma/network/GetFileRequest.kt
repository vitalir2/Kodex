package io.vitalir.kodex.data.figma.network

import io.vitalir.kodex.data.figma.network.common.GetNetworkRequest

internal class GetFileRequest(
    fileId: String,
    nodeIds: List<String>,
) : GetNetworkRequest(
    path = "v1/files/$fileId/nodes",
    queryParams = mapOf(
        "ids" to nodeIds.joinToString(","),
    )
)
