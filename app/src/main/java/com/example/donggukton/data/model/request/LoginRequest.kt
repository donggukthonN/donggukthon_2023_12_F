package com.example.donggukton.data.model.request

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequest(
    val password: String,
    val userId: String
)
