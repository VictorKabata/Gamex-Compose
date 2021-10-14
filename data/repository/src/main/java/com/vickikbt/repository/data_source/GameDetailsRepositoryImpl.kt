package com.vickikbt.repository.data_source

import com.vickikbt.domain.models.GameDetailsResponse
import com.vickikbt.domain.repository.GameDetailRepository
import com.vickikbt.network.ApiService

class GameDetailsRepositoryImpl constructor(private val apiService:ApiService):GameDetailRepository {


    override suspend fun getGameDetails(gameId: Int): GameDetailsResponse {
        TODO("Not yet implemented")
    }

}