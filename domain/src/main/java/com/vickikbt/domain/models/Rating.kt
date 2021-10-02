package com.vickikbt.domain.models

data class Rating(
    val count: Int,
    val id: Int,
    val percent: Double,
    val title: String
)