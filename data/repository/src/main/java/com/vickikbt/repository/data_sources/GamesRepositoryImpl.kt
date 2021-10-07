package com.vickikbt.repository.data_sources

import com.vickikbt.domain.models.GamesResponse
import com.vickikbt.domain.repository.GamesRepository
import com.vickikbt.network.ApiService
import com.vickikbt.network.utils.SafeApiRequest
import com.vickikbt.repository.mappers.toDomain

class GetGamesDataSource constructor(private val apiService:ApiService):GamesRepository, SafeApiRequest(){

    override suspend fun getGames(ordering: String, page: Int, perPage: Int): GamesResponse {
        return safeApiRequest { apiService.getGames(ordering = ordering,page = page, perPage = perPage) }.toDomain()
    }
}