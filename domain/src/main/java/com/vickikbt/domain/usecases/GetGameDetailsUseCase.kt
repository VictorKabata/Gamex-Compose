package com.vickikbt.domain.usecases

import com.vickikbt.common.Resource
import com.vickikbt.domain.models.GameDetailsResponse
import com.vickikbt.domain.repository.GameDetailsRepository

class GetGameDetailsUseCase constructor(private val gameDetailsRepository: GameDetailsRepository) {

    /*operator fun invoke(gameId: Int): Flow<Resource<GameDetailsResponse>> =
        flow {
            try {
            println("GameId in use case: $gameId")

            emit(Resource.Loading())
            val gamesDetailsResponse = gameDetailsRepository.getGameDetails(gameId = gameId)
            emit(Resource.Success(gamesDetailsResponse))
            } catch (e: Exception) { //ToDo: Catch specific exceptions
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
                emit(Resource.Error(e.localizedMessage))
            }
        }*/

    suspend operator fun invoke(gameId: Int): Resource<GameDetailsResponse> {
        val gamesDetailsResponse = gameDetailsRepository.getGameDetails(gameId = gameId)
        return Resource.Success(gamesDetailsResponse)
    }
}