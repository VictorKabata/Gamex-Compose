package com.vickikbt.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class RatingDto(
    val count: Int,
    val id: Int,
    val percent: Double,
    val title: String
)