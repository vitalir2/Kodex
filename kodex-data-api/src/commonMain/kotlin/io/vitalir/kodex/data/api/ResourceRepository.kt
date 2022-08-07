package io.vitalir.kodex.data.api

import io.vitalir.kodex.core.models.Resource

interface ResourceRepository<TParams, TResource : Resource> {

    suspend fun fetchResource(params: TParams): List<TResource>
}
