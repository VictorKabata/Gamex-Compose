package com.vickikbt.data.networking

import com.vickikbt.common.Constants
import com.vickikbt.data.dto.GamesResponseDto
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface GamesService {

    suspend fun getGames(
        key: String = Constants.API_KEY,
        ordering: String,
        page: Int,
        perPage: Int
    ): GamesResponseDto?


    operator fun invoke(): GamesService {
        return GamesServiceImpl(
            client = HttpClient(Android) {
                install(Logging) { level = LogLevel.ALL }
                install(JsonFeature) { serializer = KotlinxSerializer() }
            }
        )
    }


}