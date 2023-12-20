package com.example.donggukton.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestAddFriendDto(
    @SerialName("code")
    val code: Int,
    @SerialName("f_id")
    val f_id: String,
)
