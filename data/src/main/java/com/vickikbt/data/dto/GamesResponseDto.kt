package com.vickikbt.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class GamesResponseDto(
    val count: Int,
    val games_count: Int,
    val next: String,
    val previous: String,
    val recommendations_count: Int,
    val results: List<GameDto>,
    val reviews_count: Int
)