package io.vitalir.kodex.data.figma.network.common

// TODO @vitalir: Move to a common module
abstract class GetNetworkRequest(
    path: String,
    queryParams: Map<String, String> = emptyMap(),
) : NetworkRequest(
    path = path,
    queryParams = queryParams,
)
