package com.vickikbt.domain.models

data class Game(
    val added: Int?,
    val background_image: String?,
    val clip: String?,
    val community_rating: Int?,
    val dominant_color: String?,
    val genres: List<Genre>?,
    val id: Int?,
    val name: String?,
    val platforms: List<Platforms>?,
    val metacritic:Int?,
    val playtime: Int?,
    val rating: Double?,
    val rating_top: Int?,
    val ratings: List<Rating>?,
    val ratings_count: Int?,
    val released: String?,
    val reviews_count: Int?,
    val reviews_text_count: Int?,
    val saturated_color: String?,
    val short_screenshots: List<ShortScreenshot>?,
    val slug: String?,
    val suggestions_count: Int?,
    val tags: List<Tag>?,
    val tba: Boolean?,
    val updated: String?
)