package io.vitalir.kodex.data.figma

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.vitalir.kodex.data.figma.network.FigmaDataSource
import io.vitalir.kodex.data.figma.network.GetFileQueryParams

// TODO @vitalir: Get some variables from system env
class FigmaDataSourceTest : StringSpec() {
    init {
        "should get not error response" {
            val figmaToken = ""
            val fileKey = ""
            check(figmaToken.isNotBlank()) { "You should set figma token" }
            check(fileKey.isNotBlank()) { "You should set file key" }
            val figmaDataSource = FigmaDataSource(
                networkClient = HttpClient(CIO),
                figmaToken = figmaToken,
            )
            val response = figmaDataSource.getFile(
                fileKey = fileKey,
                queryParams = GetFileQueryParams("", 2U),
            )
            response.name.isEmpty() shouldBe false
        }
    }
}
