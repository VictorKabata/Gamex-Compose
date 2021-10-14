package com.vickikbt.domain.usecases

import com.vickikbt.domain.repository.GameDetailRepository

class GetGameDetailsUseCase constructor(private val gameDetailRepository: GameDetailRepository) {

    suspend operator fun invoke(gameId: Int) = gameDetailRepository.getGameDetails(gameId = gameId)

}