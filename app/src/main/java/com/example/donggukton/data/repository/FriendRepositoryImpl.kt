package com.example.donggukton.data.repository

import com.example.donggukton.data.datasource.remote.FriendDataSource
import com.example.donggukton.domain.model.result.FriendList
import com.example.donggukton.domain.repository.FriendRepository
import javax.inject.Inject

class FriendRepositoryImpl @Inject constructor(
    private val friendDataSource: FriendDataSource,
) : FriendRepository {
    override suspend fun getFriendList(u_id: String): Result<FriendList> =
        runCatching { friendDataSource.getFriendList(u_id).toFriend() }

    override suspend fun deleteFriend(u_id: String, f_id: String): Result<Unit> =
        runCatching { friendDataSource.deleteFriend(u_id, f_id) }
}
