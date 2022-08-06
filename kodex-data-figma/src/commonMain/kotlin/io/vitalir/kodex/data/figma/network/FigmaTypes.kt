package io.vitalir.kodex.data.figma.network

import kotlinx.serialization.Serializable

@Serializable
data class Paint(
    val type: String,
)

@Serializable
data class FlowStartingPoint(
    val nodeId: String,
)

@Serializable
data class ExportSetting(
    val suffix: String,
)

@Serializable
data class LayoutConstraint(
    val vertical: String,
)
@Serializable
data class Color(
    val r: Double,
    val g: Double,
    val b: Double,
    val a: Double,
)

enum class BlendMode {
    PASS_THROUGH,
    NORMAL,
    DARKEN,
    MULTIPLY,
    LINEAR_BURN,
    COLOR_BURN,
    LIGHTEN,
    SCREEN,
    LINEAR_DODGE,
    COLOR_DODGE,
    OVERLAY,
    SOFT_LIGHT,
    HARD_LIGHT,
    DIFFERENCE,
    EXCLUSION,
    HUE,
    SATURATION,
    COLOR,
    LUMINOSITY,
}
