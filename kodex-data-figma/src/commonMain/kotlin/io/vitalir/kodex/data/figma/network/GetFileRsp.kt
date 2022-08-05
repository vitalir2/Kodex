package io.vitalir.kodex.data.figma.network

import kotlinx.serialization.Serializable

@Serializable
data class GetFileRsp(
    val name: String,
    val document: Document,
)
