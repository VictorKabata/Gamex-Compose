package com.vickikbt.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ShortScreenshotDto(
    val id: Int,
    val image: String
)