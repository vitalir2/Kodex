package io.vitalir.kodex.data.figma.network

import io.vitalir.kodex.data.figma.network.common.GetNetworkRequest

internal class GetFileStylesRequest(fileKey: String) : GetNetworkRequest(
    path = "/v1/files/$fileKey/styles",
)
