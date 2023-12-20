package com.example.donggukton.domain.repository

import com.example.donggukton.data.model.request.RequestAddFriendDto
import com.example.donggukton.data.model.response.ResponseAddFriendDto
import com.example.donggukton.domain.model.result.FriendList

interface FriendRepository {

    suspend fun getFriendList(u_id: String): Result<FriendList>

    suspend fun deleteFriend(u_id: String, f_id: String): Result<Unit>

    suspend fun postFriend(u_id: String, requestAddFriendDto: RequestAddFriendDto): Result<ResponseAddFriendDto>
}
