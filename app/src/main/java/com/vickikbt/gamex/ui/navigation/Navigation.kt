package com.vickikbt.gamex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vickikbt.gamex.ui.screens.favorites.FavoritesScreen
import com.vickikbt.gamex.ui.screens.home.HomeScreen
import com.vickikbt.gamex.ui.screens.settings.SettingsScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen()
        }

        composable(NavigationItem.Favorite.route) {
            FavoritesScreen()
        }

        composable(NavigationItem.Settings.route) {
            SettingsScreen()
        }

        //ToDo: Navigate to game details screen
        /*composable(NavigationItem.Settings.route){
            SettingsScreen()
        }*/
    }
}