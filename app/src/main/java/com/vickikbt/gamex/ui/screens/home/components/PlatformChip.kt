package com.vickikbt.gamex.ui.screens.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PlatformChip(platformName: String, backgroundColor: Color, contentColor: Color) {
    Surface(
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = backgroundColor,
        contentColor = contentColor
    ) {
        Text(
            modifier = Modifier.padding(3.dp),
            text = platformName,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}