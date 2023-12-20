package com.example.donggukton.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class RequestReplyAnswer(
    val content: String,
    val flag: Int
)
