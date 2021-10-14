package com.vickikbt.gamex.ui.screens.games_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.vickikbt.domain.models.GameDetailsResponse
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import timber.log.Timber

@Composable
fun GameDetailsScreen(gameIdArg: Int, viewModel: GameDetailsViewModel = getViewModel()) {

    Timber.e("Game id: $gameIdArg")

    viewModel.getGameDetails(gameId = gameIdArg)

    val gameDetailsState = viewModel.state.value
    val gameDetails = gameDetailsState.gameDetails

    val scrollState = rememberScrollState()

    if (gameDetails != null) {
        BackgroundImage(viewModel = viewModel, gameDetails = gameDetails)
    } else {
        Timber.e("Game Details is null")
    }


}

@Composable
fun BackgroundImage(viewModel: GameDetailsViewModel, gameDetails: GameDetailsResponse) {
    val defaultDominantColor = MaterialTheme.colors.surface
    val dominantColor = remember { mutableStateOf(defaultDominantColor) }
    val dominantTextColor = remember { mutableStateOf(defaultDominantColor) }

    Timber.e("Displaying game image background")

    val painter = rememberImagePainter(
        data = gameDetails.backgroundImage,
        builder = { crossfade(true) }
    )

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(260.dp),
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop,
        painter = painter,
        contentDescription = null
    )

    if (painter.state is ImagePainter.State.Success) {
        LaunchedEffect(key1 = painter) {
            launch {
                val imageDrawable = painter.imageLoader.execute(painter.request).drawable
                viewModel.getImageDominantSwatch(imageDrawable!!) {
                    dominantColor.value = Color(it.rgb)
                    dominantTextColor.value = Color(it.titleTextColor)
                }
            }
        }
    }

}