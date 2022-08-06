package io.vitalir.kodex.data.figma.network

import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.call.*
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
        return response.body<GetFileRsp>().also { Napier.d("Got file with name=${it.name}") }
    }

    companion object {
        private const val FIGMA_API_HOST = "api.figma.com"
    }
}
