package com.vickikbt.gamex.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vickikbt.common.Resource
import com.vickikbt.domain.usecases.GetGamesUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeViewModel constructor(private val getGamesUseCase: GetGamesUseCase) : ViewModel() {

    private val _state = mutableStateOf(GamesListState())
    val state: State<GamesListState> = _state

    init {
        getGames()
    }

    private fun getGames() {
        val gamesResponse = getGamesUseCase.invoke(ordering = "relevance", page = 1, perPage = 20)
        gamesResponse.onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = GamesListState(isLoading = true)
                }

                is Resource.Success -> {
                    _state.value = GamesListState(games = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        GamesListState(error = result.message ?: "An unexpected error occured")
                }
            }
        }.launchIn(viewModelScope)
    }

}