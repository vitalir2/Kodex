package io.vitalir.kodex.data.figma.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An object that represents a node of file in Figma
 *
 * For more information, see [Figma API docs](https://www.figma.com/developers/api#files)
 */
@Serializable
internal sealed class Node {
    abstract val id: String
    abstract val name: String
    abstract val visible: Boolean
}

@Serializable
@SerialName("DOCUMENT")
internal class DocumentNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
    val children: List<Node>,
) : Node()

@Serializable
@SerialName("CANVAS")
internal data class CanvasNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
    val children: List<Node>,
    val backgroundColor: Color,
    val flowStartingPoints: List<FlowStartingPoint>,
    val exportSettings: List<ExportSetting> = emptyList(),
) : Node()

@Serializable
@SerialName("FRAME")
internal data class FrameNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
    val children: List<Node>,
    val locked: Boolean = false,
    val fills: List<Paint> = emptyList(),
    val strokes: List<Paint> = emptyList(),
    val strokeWeight: Double,
    val strokeAlign: String,
    val cornerRadius: Double? = null,
    val rectangleCornerRadii: List<Double> = List(FOUR_CORNERS) { cornerRadius ?: 0.0 },
    val exportSettings: List<ExportSetting> = emptyList(),
    val blendMode: BlendMode,
    val preserveRatio: Boolean = false,
    val constraints: LayoutConstraint,
    val layoutAlign: String? = null,
    val opacity: Double = 1.0,
    val clipsContent: Boolean,
    val paddingLeft: Double = 0.0,
    val paddingRight: Double = 0.0,
    val paddingTop: Double = 0.0,
    val paddingBottom: Double = 0.0,
    val horizontalPadding: Double = 0.0,
    val verticalPadding: Double = 0.0,
    val itemSpacing: Double = 0.0,
    val isMask: Boolean = false,
    val isMaskOutline: Boolean = false,
) : Node()

@Serializable
@SerialName("GROUP")
internal data class GroupNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
    val children: List<Node>,
    val locked: Boolean = false,
    val fills: List<Paint> = emptyList(),
    val strokes: List<Paint> = emptyList(),
    val strokeWeight: Double,
    val strokeAlign: String,
    val cornerRadius: Double? = null,
    val rectangleCornerRadii: List<Double> = List(FOUR_CORNERS) { cornerRadius ?: 0.0 },
    val exportSettings: List<ExportSetting> = emptyList(),
    val blendMode: BlendMode,
    val preserveRatio: Boolean = false,
    val constraints: LayoutConstraint,
    val layoutAlign: String? = null,
    val opacity: Double = 1.0,
    val clipsContent: Boolean,
    val paddingLeft: Double = 0.0,
    val paddingRight: Double = 0.0,
    val paddingTop: Double = 0.0,
    val paddingBottom: Double = 0.0,
    val horizontalPadding: Double = 0.0,
    val verticalPadding: Double = 0.0,
    val itemSpacing: Double = 0.0,
    val isMask: Boolean = false,
    val isMaskOutline: Boolean = false,
) : Node()

private const val FOUR_CORNERS = 4

@Serializable
@SerialName("VECTOR")
internal data class VectorNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
) : Node()

@Serializable
@SerialName("BOOLEAN_OPERATION")
internal data class BooleanOperationNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
) : Node()

@Serializable
@SerialName("STAR")
internal data class StarNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
) : Node()

@Serializable
@SerialName("LINE")
internal data class LineNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
) : Node()

@Serializable
@SerialName("ELLIPSE")
internal data class EllipseNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
) : Node()

@Serializable
@SerialName("REGULAR_POLYGON")
internal data class RegularPolygonNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
) : Node()

@Serializable
@SerialName("RECTANGLE")
internal data class RectangleNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
) : Node()

@Serializable
@SerialName("SLICE")
internal data class SliceNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
) : Node()

@Serializable
@SerialName("TEXT")
internal data class TextNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
) : Node()

@Serializable
@SerialName("COMPONENT")
internal data class NodeComponentNode(
    override val id: String = "",
    override val name: String,
    override val visible: Boolean = true,
) : Node()

@Serializable
@SerialName("COMPONENT_SET")
internal data class NodeComponentSetNode(
    override val id: String = "",
    override val name: String,
    override val visible: Boolean = true,
) : Node()

@Serializable
@SerialName("INSTANCE")
internal data class InstanceNode(
    override val id: String,
    override val name: String,
    override val visible: Boolean = true,
) : Node()
