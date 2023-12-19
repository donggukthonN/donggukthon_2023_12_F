package com.example.donggukton.data.service

import com.example.donggukton.data.model.response.ResponseFriendDto
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface FriendService {

    @GET("{u_id}/final/friend/")
    suspend fun getFriendList(
        @Path("u_id") u_id: String,
    ): ResponseFriendDto

    @DELETE("{u_id}/final/friend/delete/{f_id}/")
    suspend fun deleteFriend(
        @Path("u_id") u_id: String,
        @Path("f_id") f_id: String,
    ): Response<Unit>
}
