package io.vitalir.kodex.data.figma.network

import io.vitalir.kodex.data.figma.network.common.GetNetworkRequest

internal class GetFileRequest(
    fileKey: String,
    nodeIds: List<String>,
) : GetNetworkRequest(
    path = "v1/files/$fileKey/nodes",
    queryParams = mapOf(
        "ids" to nodeIds.joinToString(","),
    )
)
