package com.example.donggukton.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class RequestDuplicatedId(
    val userId: String
)
