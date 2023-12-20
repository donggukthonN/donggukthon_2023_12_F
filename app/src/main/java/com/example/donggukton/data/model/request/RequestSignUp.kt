package com.example.donggukton.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class RequestSignUp(
    val nickname: String,
    val password: String,
    val userId: String
)