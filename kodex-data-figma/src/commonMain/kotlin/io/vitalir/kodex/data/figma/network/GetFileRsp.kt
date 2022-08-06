package io.vitalir.kodex.data.figma.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetFileRsp(
    val name: String,
    val lastModified: String,
    val thumbnailUrl: String,
    val version: String,
    val role: String,
    val editorType: String,
    val linkAccess: String,
    val document: DocumentNode,
    val components: Map<String, Component>,
    val componentSets: Map<String, ComponentSet>,
    val schemaVersion: Int,
    val styles: Map<String, Style>,
    val mainFileKey: String = "",
    val branches: List<Node> = emptyList(),
)

@Serializable
data class Component(
    val key: String,
    val name: String,
    val description: String,
    val componentSetId: String? = null,
    val documentationLinks: List<DocumentationLink>,
)

@Serializable
data class DocumentationLink(
    val uri: String,
)

@Serializable
data class ComponentSet(
    val key: String,
    val name: String,
    val description: String,
)

@Serializable
data class Style(
    val key: String,
    val name: String,
    val description: String,
    @SerialName("style_type")
    val styleType: StyleType? = null,
)

enum class StyleType {
    FILL,
    TEXT,
    EFFECT,
    GRID,
}
