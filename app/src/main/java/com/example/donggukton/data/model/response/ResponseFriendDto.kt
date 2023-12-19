package com.example.donggukton.data.model.response

import com.example.donggukton.domain.model.result.FriendList
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseFriendDto(
    @SerialName("friends")
    val friends: List<FriendId>,
) {
    @Serializable
    data class FriendId(
        @SerialName("id")
        val id: String,
        @SerialName("complete")
        val complete: Int,
    )

    fun toFriend() = FriendList(
        friends = friends.map { friend ->
            FriendList.FriendData(
                id = friend.id,
                complete = friend.complete,
            )
        },
    )
}
