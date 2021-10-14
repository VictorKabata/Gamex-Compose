package com.vickikbt.repository.data_source

import com.vickikbt.common.Constants
import com.vickikbt.domain.models.GameDetailsResponse
import com.vickikbt.domain.repository.GameDetailRepository
import com.vickikbt.network.ApiService
import com.vickikbt.network.utils.SafeApiRequest
import com.vickikbt.repository.mappers.toDomain

class GameDetailsRepositoryImpl constructor(private val apiService: ApiService) :
    GameDetailRepository, SafeApiRequest() {

    override suspend fun getGameDetails(gameId: Int): GameDetailsResponse {


        val gameDetailsResponse = safeApiRequest {
            apiService.getGameDetails(
                apiKey = Constants.API_KEY,
                gameId = gameId
            )
        }

        return gameDetailsResponse.toDomain()
    }

}