package com.vickikbt.gamex.ui.screens.games_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.vickikbt.domain.models.GameDetailsResponse
import com.vickikbt.gamex.ui.theme.TextSecondary
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel
import timber.log.Timber

@Composable
fun GameDetailsScreen(
    gameIdArg: Int,
    viewModel: GameDetailsViewModel = getViewModel(),
    upPressed: () -> Unit
) {

    Timber.e("Game id: $gameIdArg")

    LaunchedEffect(key1 = gameIdArg) {
        viewModel.getGameDetails(gameId = gameIdArg)
    }

    val gameDetailsState = viewModel.state.value
    val gameDetails = gameDetailsState.gameDetails

    if (gameDetails != null) {
        BackgroundImage(viewModel = viewModel, gameDetails = gameDetails)
        GameDetail(gameDetails = gameDetails)
        BackButton {
            upPressed()
        }
    } else {
        Timber.e("Game Details is null")
    }
}

@Composable
fun BackgroundImage(viewModel: GameDetailsViewModel, gameDetails: GameDetailsResponse) {
    val defaultDominantColor = MaterialTheme.colors.surface
    val dominantColor = remember { mutableStateOf(defaultDominantColor) }
    val dominantTextColor = remember { mutableStateOf(defaultDominantColor) }

    val painter = rememberImagePainter(
        data = gameDetails.backgroundImage,
        builder = { crossfade(true) }
    )

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp),
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

@Composable
fun GameDetail(gameDetails: GameDetailsResponse) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(state = scrollState)
    ) {

        Text(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 8.dp)
                .padding(top = 320.dp),
            text = gameDetails.name.toString(),
            fontSize = 32.sp,
            style = MaterialTheme.typography.h2,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Start,
            color = TextSecondary
        )

        //region About
        DetailsText(text = "About")

        DetailsText(text = gameDetails.descriptionRaw.toString())
        //endregion

        Spacer(modifier = Modifier.height(12.dp))

        //region Release Date

        gameDetails.released?.let {
            DetailsText(text = "Release Date")

            DetailsText(text = it)
        }

        //endregion

        //region About
        DetailsText(text = "About")

        DetailsText(text = gameDetails.descriptionRaw.toString())
        //endregion

        //region About
        DetailsText(text = "About")

        DetailsText(text = gameDetails.descriptionRaw.toString())
        //endregion
    }
}

@Composable
fun BackButton(modifier: Modifier = Modifier, upPressed: () -> Unit) {
    Surface(
        shape = CircleShape,
        modifier = modifier
            .padding(16.dp)
            .alpha(0.6f)
    ) {
        IconButton(onClick = upPressed) {
            Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
        }
    }
}
@Composable
fun DetailsText(text: String) {
    Text(
        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
        text = text,
        fontSize = 15.sp,
        // lineHeight = 2.sp ,
        // letterSpacing = 5.sp,
        style = MaterialTheme.typography.h2,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Start,
        color = TextSecondary
    )
}
