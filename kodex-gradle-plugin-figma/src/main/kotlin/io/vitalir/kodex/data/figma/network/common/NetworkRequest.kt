package io.vitalir.kodex.data.figma.network.common

sealed class NetworkRequest(
    val path: String,
    val queryParams: Map<String, Any>,
)
