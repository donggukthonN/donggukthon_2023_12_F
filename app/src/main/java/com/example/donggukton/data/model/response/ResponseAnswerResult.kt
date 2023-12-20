package com.example.donggukton.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseAnswerResult(
    val answer: String,
    val question: String
)