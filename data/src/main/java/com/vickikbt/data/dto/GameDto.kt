package com.vickikbt.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class GameDto(
    val added: Int,
    val background_image: String,
    val clip: String,
    val community_rating: Int,
    val dominant_color: String,
    val genres: List<GenreDto>,
    val id: Int,
    val name: String,
    val platforms: List<PlatformsDto>,
    val playtime: Int,
    val rating: Double,
    val rating_top: Int,
    val ratings: List<RatingDto>,
    val ratings_count: Int,
    val released: String,
    val reviews_count: Int,
    val reviews_text_count: Int,
    val saturated_color: String,
    val short_screenshots: List<ShortScreenshotDto>,
    val slug: String,
    val suggestions_count: Int,
    val tags: List<TagDto>,
    val tba: Boolean,
    val updated: String
)