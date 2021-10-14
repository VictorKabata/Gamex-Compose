package com.vickikbt.gamex.ui.screens.games_detail

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import com.vickikbt.common.Resource
import com.vickikbt.domain.usecases.GetGameDetailsUseCase
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

class GameDetailsViewModel constructor(private val getGameDetailsUseCase: GetGameDetailsUseCase) :
    ViewModel() {

    private val _state = mutableStateOf(GameDetailsState())
    val state: State<GameDetailsState> = _state

    fun getGameDetails(gameId: Int) {
        val gameDetailsResponse = getGameDetailsUseCase.invoke(gameId = gameId)

        gameDetailsResponse.onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = GameDetailsState(isLoading = true)
                    Timber.e("Loading state")
                }
                is Resource.Success -> {
                    _state.value = GameDetailsState(gameDetails = result.data)
                    Timber.e("Success state")
                }
                is Resource.Error -> {
                    _state.value =
                        GameDetailsState(error = result.message ?: "An unexpected error occurred")
                    Timber.e("Failure state")
                }
            }
        }
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