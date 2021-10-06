package com.vickikbt.gamex.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vickikbt.domain.models.Game
import com.vickikbt.gamex.R
import com.vickikbt.gamex.ui.theme.ColorPrimary

@Composable
fun HomeScreen() {
    Scaffold(topBar = { SearchBar() }) {

    }
}

@Composable
fun SearchBar() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(width = 0.5.dp, color = ColorPrimary)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 16.dp),
            text = stringResource(id = R.string.search),
            fontSize = 20.sp,
            color = Color.Gray
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun GamesGrid(gamesList: List<Game>) {
    LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(8.dp)) {
        items(gamesList) { item ->
            GameGridItem(gameImageUrl = item.background_image, gameTitle = item.name)
        }
    }
}

@Composable
fun GameGridItem(gameImageUrl: String, gameTitle: String) {
    Column(modifier = Modifier.padding(8.dp)) {
        Card(
            modifier = Modifier
                .height(220.dp)
                .width(220.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = rememberImagePainter(
                    data = gameImageUrl,
                    builder = { crossfade(true) }), contentDescription = null
            )
        }

        Text(
            text = gameTitle,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 2,
            textAlign = TextAlign.Start
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    HomeScreen()
}