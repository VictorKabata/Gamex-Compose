package com.vickikbt.gamex.ui.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchScreen(){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Search Screen")
    }
}

@Preview(showBackground = true)
@Composable
fun Preview(){
    SearchScreen()
}