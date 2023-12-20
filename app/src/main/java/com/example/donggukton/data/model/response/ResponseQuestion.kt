package com.example.donggukton.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseQuestion(
    val content: String,
    val questionNum: Int
)
