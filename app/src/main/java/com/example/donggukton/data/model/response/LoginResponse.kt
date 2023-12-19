package com.example.donggukton.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val message: String,
    val success: Boolean,
    val userId: String
)