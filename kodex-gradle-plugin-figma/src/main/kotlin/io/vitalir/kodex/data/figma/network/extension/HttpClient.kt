package io.vitalir.kodex.data.figma.network.extension

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

fun createFigmaExportHttpClient(figmaToken: String): HttpClient = HttpClient(CIO) {
    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
            }
        )
    }
    install(DefaultRequest) {
        url("https://$FIGMA_API_HOST")
        headers {
            header("X-Figma-Token", figmaToken)
        }
    }
}

private const val FIGMA_API_HOST = "api.figma.com"
