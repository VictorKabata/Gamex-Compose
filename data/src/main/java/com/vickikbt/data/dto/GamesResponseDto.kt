package com.vickikbt.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GamesResponseDto(
    @SerialName("count")
    val count: Int,

    @SerialName("game_count")
    val games_count: Int,

    @SerialName("next")
    val next: String,

    @SerialName("previous")
    val previous: String,

    @SerialName("recommendations_count")
    val recommendations_count: Int,

    @SerialName("results")
    val results: List<GameDto>,

    @SerialName("reviews_count")
    val reviews_count: Int
)