package io.vitalir.kodex.data.figma.network

import kotlinx.serialization.Serializable

@Serializable
data class Paint(
    val type: String,
    val color: Color,
    val opacity: Double,
)

@Serializable
data class Color(
    val r: Double,
    val g: Double,
    val b: Double,
    val a: Double,
)
