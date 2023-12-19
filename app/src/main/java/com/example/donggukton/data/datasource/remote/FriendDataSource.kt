package com.example.donggukton.data.datasource.remote

import com.example.donggukton.data.model.response.ResponseFriendDto
import com.example.donggukton.data.service.FriendService
import retrofit2.Response
import javax.inject.Inject

class FriendDataSource @Inject constructor(
    private val friendService: FriendService,
) {
    suspend fun getFriendList(u_id: String): ResponseFriendDto =
        friendService.getFriendList(u_id)

    suspend fun deleteFriend(u_id: String, f_id: String): Response<Unit> =
        friendService.deleteFriend(u_id, f_id)
}
