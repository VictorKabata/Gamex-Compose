package com.vickikbt.domain.usecases

import com.vickikbt.common.Resource
import com.vickikbt.domain.models.GamesResponse
import com.vickikbt.domain.repository.GamesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetGamesUseCase constructor(private val gameRepository: GamesRepository) {

    operator fun invoke(ordering: String, page: Int, perPage: Int): Flow<Resource<GamesResponse>> =
        flow {
            //try {

            emit(Resource.Loading())
            val gamesResponse = gameRepository.getGames(ordering, page, perPage)
            emit(Resource.Success(gamesResponse))
            /*} catch (e: Exception) { //ToDo: Catch specific exceptions
                //emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
                emit(Resource.Error(e.localizedMessage))
            }*/
        }

}