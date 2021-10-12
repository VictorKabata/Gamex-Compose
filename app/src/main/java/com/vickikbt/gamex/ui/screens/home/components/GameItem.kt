package com.vickikbt.gamex.ui.screens.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.vickikbt.domain.models.Game
import com.vickikbt.gamex.ui.screens.home.HomeViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel

@Composable
fun GameItem(
    game: Game,
    viewModel: HomeViewModel = getViewModel(),
    onItemClick: (Game) -> Unit
) {
    val defaultDominantBackgroundColor = MaterialTheme.colors.surface
    val defaultDominantTextColor = MaterialTheme.colors.onSurface

    val dominantBackgroundColor = remember { mutableStateOf(defaultDominantBackgroundColor) }
    val dominantTextColor = remember { mutableStateOf(defaultDominantTextColor) }

    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            dominantBackgroundColor.value,
                            defaultDominantBackgroundColor
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
                            dominantBackgroundColor.value = Color(it.rgb)
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
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 1.dp),
                            text = game.metacritic.toString(),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
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
                fontWeight = FontWeight.ExtraBold,
                maxLines = 2,
                textAlign = TextAlign.Start,
                color = dominantTextColor.value
            )
        }
    }
}