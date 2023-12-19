package com.example.donggukton.data.repository

import com.example.donggukton.data.datasource.remote.AuthDataSource
import com.example.donggukton.data.model.request.LoginRequest
import com.example.donggukton.data.model.response.LoginResponse
import com.example.donggukton.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
) : AuthRepository {
    override suspend fun login(loginRequest: LoginRequest): Result<LoginResponse> =
        runCatching {
            authDataSource.login(loginRequest)
        }
}