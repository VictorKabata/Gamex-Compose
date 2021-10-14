package com.vickikbt.domain.repository

import com.vickikbt.domain.models.GameDetailsResponse

interface GameDetailRepository {

    suspend fun getGameDetails(gameId:Int):GameDetailsResponse

}