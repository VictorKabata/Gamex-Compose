package com.vickikbt.domain.models

data class GamesResponse(
    val count: Int?,
    val games_count: Int?,
    val next: String?,
    val previous: String?,
    val recommendations_count: Int?,
    val results: List<Game>?,
    val reviews_count: Int?
)