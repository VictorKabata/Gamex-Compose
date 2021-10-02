package com.vickikbt.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class StoresDto(
    val id: Int,
    val store: StoreDto
)