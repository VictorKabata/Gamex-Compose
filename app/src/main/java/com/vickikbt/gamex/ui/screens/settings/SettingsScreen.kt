package com.vickikbt.gamex.ui.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SettingsScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Settings Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    SettingsScreen()
}