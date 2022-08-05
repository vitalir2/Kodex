package io.vitalir.kodex.data.figma.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An object that represents a node of file in Figma
 *
 * For more information, see [Figma API docs](https://www.figma.com/developers/api#files)
 */
@Serializable
sealed class Node {
    abstract val id: String
    abstract val name: String
    abstract val visible: Boolean
}

@Serializable
@SerialName("DOCUMENT")
class Document(
    override val id: String,
    override val name: String,
    override val visible: Boolean,
    val children: List<Node>,
) : Node()
