package io.vitalir.kodex.core.models

data class TextStyle(
    override val name: String,
    val fontMetrics: FontMetrics,
    val lineHeight: Double,
    val letterSpacing: Double,
    val textColor: Color,
) : Resource
