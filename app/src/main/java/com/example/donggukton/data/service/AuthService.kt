package com.example.donggukton.data.service

import com.example.donggukton.data.model.request.LoginRequest
import com.example.donggukton.data.model.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("login/")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}
