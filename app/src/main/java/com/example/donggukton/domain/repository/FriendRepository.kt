package com.example.donggukton.domain.repository

import com.example.donggukton.domain.model.result.FriendList

interface FriendRepository {

    suspend fun getFriendList(u_id: String): Result<FriendList>

    suspend fun deleteFriend(u_id: String, f_id: String): Result<Unit>
}
