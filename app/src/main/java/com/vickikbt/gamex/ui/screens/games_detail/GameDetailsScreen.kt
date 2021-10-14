package com.vickikbt.gamex.ui.screens.games_detail

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun GameDetailsScreen(gameIdArg: Int) {
    val scrollState = rememberScrollState()

    val defaultDominantColor = MaterialTheme.colors.surface
    val dominantColor = remember { mutableStateOf(defaultDominantColor) }
    val dominantTextColor = remember { mutableStateOf(defaultDominantColor) }

    /*Column() {
        val painter = rememberImagePainter(
            data = game.background_image,
            builder = { crossfade(true) }
        )

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp),
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
    }*/

}