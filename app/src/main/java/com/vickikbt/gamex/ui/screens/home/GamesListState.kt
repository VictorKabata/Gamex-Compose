package com.vickikbt.gamex.ui.screens.home

import com.vickikbt.domain.models.GamesResponse

data class GamesListState(
    val isLoading: Boolean=false,
    val games: GamesResponse?=null,
    val error: String = ""
)
