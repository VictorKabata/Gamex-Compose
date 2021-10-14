package com.vickikbt.gamex.ui.screens.games_detail

import com.vickikbt.domain.models.GameDetailsResponse

data class GameDetailsState(
    val isLoading: Boolean = false,
    val gameDetails: GameDetailsResponse? = null,
    val error: String = ""
)
