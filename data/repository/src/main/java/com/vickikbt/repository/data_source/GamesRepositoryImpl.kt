package com.vickikbt.repository.data_source

import com.vickikbt.common.Constants
import com.vickikbt.domain.models.GamesResponse
import com.vickikbt.domain.repository.GamesRepository
import com.vickikbt.network.ApiService
import com.vickikbt.network.utils.SafeApiRequest
import com.vickikbt.repository.mappers.toDomain

class GamesRepositoryImpl constructor(private val apiService: ApiService) : GamesRepository,
    SafeApiRequest() {

    override suspend fun getGames(ordering: String, page: Int, perPage: Int): GamesResponse {
        val getGamesResponse = safeApiRequest {
            apiService.getGames(
                apiKey = Constants.API_KEY,
                ordering = ordering,
                page = page,
                perPage = perPage
            )
        }
        return getGamesResponse.toDomain()
    }
}