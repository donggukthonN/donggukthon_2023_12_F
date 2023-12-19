package com.example.donggukton.data.datasource.remote

import com.example.donggukton.data.model.request.LoginRequest
import com.example.donggukton.data.model.response.LoginResponse
import com.example.donggukton.data.service.AuthService
import javax.inject.Inject

class AuthDataSource @Inject constructor(
    private val authService: AuthService
) {
    suspend fun login(loginRequest: LoginRequest): LoginResponse = authService.login(loginRequest)
}
