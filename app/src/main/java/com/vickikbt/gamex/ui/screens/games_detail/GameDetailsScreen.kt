package com.vickikbt.gamex.ui.screens.games_detail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.vickikbt.gamex.ui.theme.ColorPrimary

@Composable
fun GameDetailsScreen(gameIdArg: Int) {

    Text(text = "Game id passed: $gameIdArg", color = ColorPrimary, fontSize = 20.sp)

}