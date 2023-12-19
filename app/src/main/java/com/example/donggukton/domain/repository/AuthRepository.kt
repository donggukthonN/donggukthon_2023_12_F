package com.example.donggukton.domain.repository

import com.example.donggukton.data.model.request.LoginRequest
import com.example.donggukton.data.model.response.LoginResponse

interface AuthRepository {
    suspend fun login(loginRequest: LoginRequest): Result<LoginResponse>
}
