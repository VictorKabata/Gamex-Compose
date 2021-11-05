package com.vickikbt.gamex.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import com.vickikbt.gamex.ui.screens.favorites.FavoritesScreen
import com.vickikbt.gamex.ui.screens.games_detail.GameDetailsScreen
import com.vickikbt.gamex.ui.screens.home.HomeScreen
import com.vickikbt.gamex.ui.screens.search.SearchScreen

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(NavigationItem.Search.route) {
            SearchScreen()
        }

        composable(NavigationItem.Favorite.route) {
            FavoritesScreen()
        }

        composable(
            NavigationItem.GameDetails.route + "{gameId}",
            arguments = listOf(navArgument("gameId") { type = NavType.IntType })
        ) {
            val gameId = it.arguments?.getInt("gameId")
            GameDetailsScreen(gameIdArg = gameId!!) {
                navController.navigateUp()
            }
        }
    }
}
