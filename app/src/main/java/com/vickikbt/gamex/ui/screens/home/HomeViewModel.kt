package com.vickikbt.gamex.ui.screens.home

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
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
        val gamesResponse = getGamesUseCase.invoke(ordering = "relevance", page = 1, perPage = 5)
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
                        GamesListState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getImageDominantSwatch(drawable: Drawable, onGenerated: (Palette.Swatch) -> Unit) {
        val bitmap = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
        Palette.from(bitmap).generate { palette ->
            palette?.dominantSwatch?.let {
                onGenerated(it)
            }
        }
    }

}