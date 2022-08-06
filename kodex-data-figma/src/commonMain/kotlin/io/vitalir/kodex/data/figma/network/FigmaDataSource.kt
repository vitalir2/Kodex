package io.vitalir.kodex.data.figma.network

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.http.*

class FigmaDataSource(
    private val networkClient: HttpClient,
    private val figmaToken: String,
) {

    suspend fun getFile(fileKey: String, queryParams: GetFileQueryParams): GetFileRsp {
        val response = networkClient.get {
            url {
                protocol = URLProtocol.HTTPS
                host = FIGMA_API_HOST
                appendPathSegments("v1", "files", fileKey)
                parameters.apply {
                    append("ids", queryParams.commaSeparatedIds)
                    append("depth", queryParams.depth.toString())
                }
            }
            headers {
                append("X-FIGMA-TOKEN", figmaToken)
            }
        }
        // TODO @vitalir: Add logger
        return response.body<GetFileRsp>().also { println(it.name) }
    }

    companion object {
        private const val FIGMA_API_HOST = "https://api.figma.com"
    }
}
