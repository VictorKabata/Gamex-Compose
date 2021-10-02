package com.vickikbt.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class TagDto(
    val games_count: Int,
    val id: Int,
    val image_background: String,
    val language: String,
    val name: String,
    val slug: String
)