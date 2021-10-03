package com.vickikbt.domain.repository

import com.vickikbt.domain.models.GamesResponse

interface GamesRepository {

    suspend fun getGames(ordering:String, page:Int, perPage:Int):GamesResponse

}