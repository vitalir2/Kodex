package io.vitalir.kodex.data.figma.network.common

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlin.reflect.KClass

// TODO @vitalir: Move to a common module
class NetworkDataSource(
    private val client: HttpClient,
) {

    @Suppress("UNCHECKED_CAST")
    suspend fun <TResponse : Any> execute(
        request: NetworkRequest,
        responseClass: KClass<TResponse>,
    ): Result<TResponse> {
        when (request) {
            is GetNetworkRequest -> {
                val result = client.get {
                    url {
                        path(request.path)
                        for ((queryName, queryValue) in request.queryParams) {
                            parameter(queryName, queryValue)
                        }
                    }
                }
                return try {
                    Result.success(result.bodyAsChannel() as TResponse)
                } catch (ex: ClassCastException) {
                    Result.failure(ex)
                }
            }
        }
    }
}

suspend inline fun <reified TResponse : Any> NetworkDataSource.execute(
    request: NetworkRequest
): Result<TResponse> = execute(request, TResponse::class)
