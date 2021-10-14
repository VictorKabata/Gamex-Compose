package com.vickikbt.gamex.ui.screens.home.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.vickikbt.domain.models.Game
import com.vickikbt.gamex.ui.screens.home.HomeViewModel
import com.vickikbt.gamex.ui.theme.TextSecondary
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@ExperimentalMaterialApi
@Composable
fun GameItem(
    game: Game,
    viewModel: HomeViewModel = getViewModel(),
    onItemClick: (Game) -> Unit
) {
    val defaultDominantColor = MaterialTheme.colors.surface
    val dominantColor = remember { mutableStateOf(defaultDominantColor) }
    val dominantTextColor = remember { mutableStateOf(defaultDominantColor) }

    val expandedState = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 500,
                    easing = LinearOutSlowInEasing
                )
            ),
        elevation = 16.dp,
        shape = RoundedCornerShape(8.dp),
        onClick = { expandedState.value = !expandedState.value }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            dominantColor.value,
                            MaterialTheme.colors.surface
                        )
                    )
                )
        ) {

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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(horizontal = 10.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                val platformLogos = platformLogo(platforms = game.platforms!!)

                LazyRow {
                    items(items = platformLogos) { platformLogo ->
                        PlatformLogoItem(platformImageResource = platformLogo)
                    }
                }

                if (game.metacritic != null) {
                    val ratingColor =
                        if (game.metacritic!! <= 40) Color.Red else if (game.metacritic!! <= 70) Color.Yellow else Color.Green

                    Card(
                        elevation = 8.dp,
                        border = BorderStroke(1.dp, ratingColor),
                        shape = RoundedCornerShape(6.dp),
                        backgroundColor = Color.Transparent
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 2.dp),
                            text = game.metacritic.toString(),
                            fontSize = 18.sp,
                            style = MaterialTheme.typography.h5,
                            maxLines = 1,
                            textAlign = TextAlign.Center,
                            color = ratingColor
                        )
                    }
                }
            }

            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                text = game.name.toString(),
                fontSize = 24.sp,
                maxLines = 2,
                style = MaterialTheme.typography.h2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                color = TextSecondary
            )

            if (expandedState.value) {
                //Release date Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                        text = "Release date: ",
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.body1,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start,
                        color = TextSecondary
                    )

                    Text(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                        text = game.released.toString(),
                        fontSize = 15.sp,
                        style = MaterialTheme.typography.h5,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start,
                        color = TextSecondary
                    )

                }

                //Genre list Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                        text = "Genres: ",
                        fontSize = 14.sp,
                        style = MaterialTheme.typography.body1,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Start,
                        color = TextSecondary
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        game.genres?.forEach { genre ->
                            Text(
                                modifier = Modifier.padding(horizontal = 2.dp),
                                text = genre.name.toString(),
                                fontSize = 15.sp,
                                style = MaterialTheme.typography.h5,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Start,
                                color = TextSecondary
                            )
                        }
                    }

                }

                //More Details button
                GradientButton(
                    text = "More Details",
                    gradient = Brush.horizontalGradient(
                        listOf(
                            dominantColor.value,
                            dominantColor.value.copy(alpha = 0.3F)
                        )
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    onClick = { onItemClick(game) }
                )
            }
        }
    }
}

@Composable
fun GradientButton(
    text: String,
    gradient: Brush,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        shape = RoundedCornerShape(8.dp),
        onClick = { onClick() },
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                modifier = Modifier
                    .padding(vertical = 6.dp)
                    .background(color = Color.Transparent),
                text = text,
                style = MaterialTheme.typography.body1,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = TextSecondary
            )
        }
    }
}

@Preview
@Composable
fun Preview() {

}