package com.vickikbt.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class PlatformDto(
    val games_count: Int,
    val id: Int,
    val image: String,
    val image_background: String,
    val name: String,
    val slug: String,
    val year_end: Any,
    val year_start: Int
)