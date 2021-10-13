package com.vickikbt.gamex.ui.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vickikbt.domain.models.Game
import com.vickikbt.gamex.R
import com.vickikbt.gamex.ui.screens.home.components.GameItem
import com.vickikbt.gamex.ui.screens.home.components.HomeToolbar
import com.vickikbt.gamex.ui.theme.ColorPrimary
import org.koin.androidx.compose.getViewModel
import timber.log.Timber

@ExperimentalMaterialApi
@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel()) {
    val gamesState = viewModel.state.value
    val gameList = gamesState.games?.results

    Scaffold(topBar = { HomeToolbar() }) {
        if (gameList != null) GamesGrid(gamesList = gameList)
        else Timber.e("Games list is null")
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

@ExperimentalMaterialApi
@Composable
fun GamesGrid(gamesList: List<Game>) {

    LazyColumn(contentPadding = PaddingValues(8.dp)) {
        items(gamesList) { item ->
            GameItem(game = item) {
                //ToDo: Navigate to game detail on click
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    //HomeScreen()
}