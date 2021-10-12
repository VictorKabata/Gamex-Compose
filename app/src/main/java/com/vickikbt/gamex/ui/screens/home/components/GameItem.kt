package com.vickikbt.gamex.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vickikbt.domain.models.Game
import com.vickikbt.gamex.ui.theme.White

@Composable
fun GameItem(
    game: Game,
    onItemClick: (Game) -> Unit
) {
    Card(modifier = Modifier.padding(8.dp), elevation = 8.dp, shape = RoundedCornerShape(8.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop,
                painter = rememberImagePainter(
                    data = game.background_image,
                    builder = { crossfade(true) }), contentDescription = null
            )

            Row(
                modifier = Modifier
                    //.padding(horizontal = 10.dp, vertical = 12.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                LazyRow {
                    items(items = game.platforms!!) { platformItem ->
                        PlatformChip(
                            platformName = platformItem.platform!!.name!!,
                            backgroundColor = MaterialTheme.colors.secondary,
                            contentColor = White
                        )
                    }
                }

                if (game.rating!! > 0 || game.rating != null) {
                    Text(
                        text = game.rating.toString(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Text(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 12.dp),
                text = game.name.toString(),
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                maxLines = 2,
                textAlign = TextAlign.Start
            )
        }
    }
}