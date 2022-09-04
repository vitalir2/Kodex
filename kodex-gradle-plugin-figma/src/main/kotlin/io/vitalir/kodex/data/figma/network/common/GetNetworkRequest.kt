package io.vitalir.kodex.data.figma.network.common

abstract class GetNetworkRequest(
    path: String,
    queryParams: Map<String, String> = emptyMap(),
) : NetworkRequest(
    path = path,
    queryParams = queryParams,
)
