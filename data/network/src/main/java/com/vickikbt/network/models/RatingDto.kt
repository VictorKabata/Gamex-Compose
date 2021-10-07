package com.vickikbt.network.models

import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("count")
    val count: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("percent")
    val percent: Double,

    @SerializedName("title")
    val title: String
)