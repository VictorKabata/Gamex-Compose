package com.vickikbt.network.models

import com.google.gson.annotations.SerializedName

data class GamesResponseDto(
    @SerializedName("count")
    val count: Int,

    @SerializedName("game_count")
    val games_count: Int,

    @SerializedName("next")
    val next: String,

    @SerializedName("previous")
    val previous: String,

    @SerializedName("recommendations_count")
    val recommendations_count: Int,

    @SerializedName("results")
    val games: List<GameDto>,

    @SerializedName("reviews_count")
    val reviews_count: Int
)