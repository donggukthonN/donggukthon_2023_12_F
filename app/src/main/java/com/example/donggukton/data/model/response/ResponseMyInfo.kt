package com.example.donggukton.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseMyInfo(
    val code: Int,
    val nickname: String,
    val password: String,
    val startDate: String,
    val userId: String
)
