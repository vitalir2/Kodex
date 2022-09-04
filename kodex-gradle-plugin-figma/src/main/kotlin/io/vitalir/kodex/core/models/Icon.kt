package io.vitalir.kodex.core.models

data class Icon(
    override val name: String,
    val size: Size,
    val format: IconFormat,
    val tint: Color?,
) : Resource
