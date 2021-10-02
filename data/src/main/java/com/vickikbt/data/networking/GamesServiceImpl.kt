package com.vickikbt.data.networking

import com.vickikbt.common.Constants
import com.vickikbt.data.dto.GamesResponseDto
import io.ktor.client.*
import io.ktor.client.request.*

class GamesServiceImpl constructor(private val client:HttpClient):GamesService {

    //ToDo: Catch http errors
    override suspend fun getGames(
        key: String,
        ordering: String,
        page: Int,
        perPage: Int
    ): GamesResponseDto? {
        return client.get {
            url(Constants.GAMES_ENDPOINT)
            parameter("key", key)
            parameter("ordering", ordering)
            parameter("page", page)
            parameter("per_page", perPage)
        }
    }
}