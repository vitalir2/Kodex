package io.vitalir.kodex.data.figma.network.common

// TODO @vitalir: Move to a common module
sealed class NetworkRequest(
    val path: String,
    val queryParams: Map<String, Any>,
)
