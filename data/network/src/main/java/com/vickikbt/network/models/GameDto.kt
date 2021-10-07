package com.vickikbt.network.models

import com.google.gson.annotations.SerializedName

data class GameDto(

    @SerializedName("added")
    val added: Int,

    @SerializedName("background_image")
    val backgroundImage: String,

    @SerializedName("clip")
    val clip: String,

    @SerializedName("community_rating")
    val communityRating: Int,

    @SerializedName("dominant_color")
    val dominantColor: String,

    @SerializedName("genres")
    val genres: List<GenreDto>,

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("platforms")
    val platforms: List<PlatformsDto>,

    @SerializedName("playtime")
    val playtime: Int,

    @SerializedName("rating")
    val rating: Double,

    @SerializedName("rating_top")
    val ratingTop: Int,

    @SerializedName("ratings")
    val ratings: List<RatingDto>,

    @SerializedName("ratings_count")
    val ratingsCount: Int,

    @SerializedName("released")
    val released: String,

    @SerializedName("reviews_count")
    val reviewsCount: Int,

    @SerializedName("reviews_text_count")
    val reviewsTextCount: Int,

    @SerializedName("saturated_color")
    val saturatedColor: String,

    @SerializedName("short_screenshots")
    val shortScreenshots: List<ShortScreenshotDto>,

    @SerializedName("slug")
    val slug: String,

    @SerializedName("suggestions_count")
    val suggestionsCount: Int,

    @SerializedName("tags")
    val tags: List<TagDto>,

    @SerializedName("tba")
    val tba: Boolean,

    @SerializedName("updated")
    val updated: String
)
