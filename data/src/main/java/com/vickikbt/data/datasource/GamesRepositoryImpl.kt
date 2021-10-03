package com.vickikbt.data.datasource

import com.vickikbt.data.mappers.toDomain
import com.vickikbt.data.networking.GamesService
import com.vickikbt.domain.models.GamesResponse
import com.vickikbt.domain.repository.GamesRepository

class GamesRepositoryImpl constructor(private val gamesService: GamesService) : GamesRepository {

    override suspend fun getGames(ordering: String, page: Int, perPage: Int): GamesResponse {
        return gamesService.getGames(ordering = ordering, page = page, perPage = perPage)!!
            .toDomain()
    }
}