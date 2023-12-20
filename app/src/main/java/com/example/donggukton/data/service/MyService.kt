package com.example.donggukton.data.service

import com.example.donggukton.data.model.response.ResponseMyInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface MyService {
    @GET("{u_id}/final/profile/")
    suspend fun getMyProfile(
        @Path("u_id") u_id: String,
    ): ResponseMyInfo
}
