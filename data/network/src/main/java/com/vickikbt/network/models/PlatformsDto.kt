package com.vickikbt.network.models

import com.google.gson.annotations.SerializedName


data class PlatformsDto(
    @SerializedName("platform")
    val platformDetail: PlatformDetailDto?
)