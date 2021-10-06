package com.vickikbt.gamex.ui.navigation

import com.vickikbt.gamex.R

sealed class NavigationItem(var route: String, var title: String, var icon: Int) {

    object Home : NavigationItem("home", "Home", R.drawable.ic_home)
    object Search : NavigationItem("favorites", "Favorites", R.drawable.ic_favorite)
    object Settings : NavigationItem("settings", "Settings", R.drawable.ic_settings)

}