package com.example.donggukton.domain.model.result

data class FriendList(
    val friends: List<FriendData>,
) {
    data class FriendData(
        val id: String,
        val complete: Int,
        val nickname: String,
    )
}
