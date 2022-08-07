package io.vitalir.kodex.data.figma.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetFileStylesResponse(
    val status: Int,
    val error: Boolean,
    val message: String? = null,
    val meta: FileMetaData,
)

@Serializable
data class FileMetaData(
    val styles: List<Style>,
)

@Serializable
data class Style(
    val key: String,
    @SerialName("node_id")
    val nodeId: String,
    val name: String,
)
