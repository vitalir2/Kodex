package io.vitalir.kodex.core.models

data class Color(
    override val name: String,
    val rgb: Int,
) : Resource
