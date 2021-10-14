package com.vickikbt.domain.usecases

import com.vickikbt.common.Resource
import com.vickikbt.domain.models.GameDetailsResponse
import com.vickikbt.domain.repository.GameDetailRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetGameDetailsUseCase constructor(private val gameDetailRepository: GameDetailRepository) {

    operator fun invoke(gameId: Int): Flow<Resource<GameDetailsResponse>> =
        flow {
            //try {
            emit(Resource.Loading())
            val gamesDetailsResponse = gameDetailRepository.getGameDetails(gameId = gameId)
            emit(Resource.Success(gamesDetailsResponse))
            /*} catch (e: Exception) { //ToDo: Catch specific exceptions
                //emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
                emit(Resource.Error(e.localizedMessage))
            }*/
        }


}