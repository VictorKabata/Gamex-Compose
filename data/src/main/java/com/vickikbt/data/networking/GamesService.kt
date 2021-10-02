package com.vickikbt.data.networking

import com.vickikbt.data.dto.GamesResponseDto
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

interface GamesService {

    suspend fun getGames(key:String, ordering:String, page:Int, perPage:Int):GamesResponseDto?

    companion object{
        fun create():GamesService{
            return GamesServiceImpl(
                client = HttpClient(Android){
                    install(Logging){level=LogLevel.ALL}
                    install(JsonFeature){serializer=KotlinxSerializer()}
                }
            )
        }
    }

}