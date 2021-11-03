package com.vickikbt.gamex.ui.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.vickikbt.domain.models.Game
import com.vickikbt.gamex.ui.screens.home.components.GameItem
import com.vickikbt.gamex.ui.screens.home.components.HomeToolbar
import org.koin.androidx.compose.getViewModel
import timber.log.Timber

@ExperimentalMaterialApi
@Composable
fun HomeScreen(viewModel: HomeViewModel = getViewModel(), navController: NavHostController) {
    val gamesState = viewModel.state.value
    val gameList = gamesState.games?.results

    Scaffold(topBar = { HomeToolbar() }) {
        if (gameList != null) GamesGrid(gamesList = gameList, navController = navController)
        else Timber.e("Games list is null")
    }

}

@ExperimentalMaterialApi
@Composable
fun GamesGrid(gamesList: List<Game>, navController: NavHostController) {

    LazyColumn(contentPadding = PaddingValues(horizontal = 8.dp, vertical = 6.dp)) {
        items(gamesList) { item ->
            GameItem(game = item) {
                Timber.e("Game clicked in home screen: $it")
                Timber.e("Game ID clicked in home screen: ${it.id}")
                navController.navigate("details/${it.id}")
            }
        }
    }
}