package com.vickikbt.repository.data_source

import com.vickikbt.common.Constants
import com.vickikbt.domain.models.GameDetailsResponse
import com.vickikbt.domain.repository.GameDetailsRepository
import com.vickikbt.network.ApiService
import com.vickikbt.network.utils.SafeApiRequest
import com.vickikbt.repository.mappers.toDomain

class GameDetailsRepositoryImpl constructor(private val apiService: ApiService) :
    GameDetailsRepository, SafeApiRequest() {

    override suspend fun getGameDetails(gameId: Int): GameDetailsResponse {

        println("GameId in gameDetailsRepoImpl: $gameId")

        val gameDetailsResponse = safeApiRequest {
            apiService.getGameDetails(
                apiKey = Constants.API_KEY,
                gameId = gameId
            )
        }

        return gameDetailsResponse.toDomain()
    }

}