package com.vickikbt.gamex.ui.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.vickikbt.domain.models.Platforms
import com.vickikbt.gamex.R

@Composable
fun PlatformLogoItem(platformImageResource: Int) {
    Image(
        modifier = Modifier
            .size(24.dp)
            .padding(horizontal = 2.dp),
        alignment = Alignment.Center,
        painter = rememberImagePainter(
            data = platformImageResource,
            builder = { crossfade(true) }), contentDescription = null
    )
}

fun platformLogo(platforms: List<Platforms>): List<Int> {
    val platformLogosList = mutableListOf<Int>()

    platforms.forEach { platformItem ->
        val platformName = platformItem.platform!!.name!!.lowercase()

        if (platformName.contains("pc") || platformName.contains("windows")) {
            platformLogosList.add(R.drawable.ic_windows)
        } else if (platformName.contains("xbox")) {
            platformLogosList.add(R.drawable.ic_xbox)
        } else if (platformName.contains("playstation")) {
            platformLogosList.add(R.drawable.ic_playstation)
        } else if (platformName.contains("linux")) {
            platformLogosList.add(R.drawable.ic_linux)
        } else if (platformName.contains("android")) {
            platformLogosList.add(R.drawable.ic_android)
        } else if (platformName.contains("apple") || platformName.contains("mac")) {
            platformLogosList.add(R.drawable.ic_apple)
        } else if (platformName.contains("nintendo") || platformName.contains("switch")) {
            //platformLogosList.add(R.drawable.ic_windows)
            //ToDo: Display log for nitendo
        }
    }

    return platformLogosList
}