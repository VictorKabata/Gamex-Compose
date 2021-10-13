package com.vickikbt.gamex.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.vickikbt.gamex.R

val Roboto = FontFamily(
    Font(R.font.roboto, weight = FontWeight.Normal),
    Font(R.font.roboto_medium, weight = FontWeight.Medium),
    Font(R.font.roboto_bold, weight = FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal
    ),

    h2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.ExtraBold
    ),

    h3 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Bold
    ),

    h5 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium
    )
)
