package com.vickikbt.network.models

import com.google.gson.annotations.SerializedName

data class PlatformDto(

    @SerializedName("games_count")
    val gamesCount: Int?,

    @SerializedName("id")
    val id: Int?,

    @SerializedName("image")
    val image: String?,

    @SerializedName("image_background")
    val imageBackground: String?,

    @SerializedName("name")
    val name: String?,

    @SerializedName("slug")
    val slug: String?,

    @SerializedName("year_end")
    val yearEnd: String?,

    @SerializedName("year_start")
    val yearStart: Int?
)