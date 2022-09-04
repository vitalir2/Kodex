package io.vitalir.kodex.core.models

data class Color(
    override val name: String,
    val red: Double,
    val green: Double,
    val blue: Double,
    val alpha: Double,
) : Resource
