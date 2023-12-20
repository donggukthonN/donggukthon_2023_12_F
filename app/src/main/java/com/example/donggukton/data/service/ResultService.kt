package com.example.donggukton.data.service

import com.example.donggukton.data.model.response.ResponseResultDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ResultService {

    @GET("{u_id}/final/book/")
    suspend fun getMyResult(
        @Path("u_id") u_id: String,
    ): ResponseResultDto

    @GET("{u_id}/final/friend/{f_id}/book/")
    suspend fun getFriendResult(
        @Path("u_id") u_id: String,
        @Path("f_id") f_id: String,
    ): ResponseResultDto
}
