package io.vitalir.kodex.data.figma.repository

import io.vitalir.kodex.core.models.Color
import io.vitalir.kodex.data.api.ResourceRepository

class FigmaColorRepository : ResourceRepository<Nothing, Color> {

    override suspend fun fetchResource(params: Nothing): Color {
        TODO()
    }
}
