package io.vitalir.kodex.core.models

data class Image(
    override val name: String,
    val size: Size,
    val format: ImageFormat,
) : Resource
