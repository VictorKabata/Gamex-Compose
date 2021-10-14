package com.vickikbt.domain.repository

import com.vickikbt.domain.models.GameDetailsResponse

interface GameDetailsRepository {

    suspend fun getGameDetails(gameId:Int):GameDetailsResponse

}