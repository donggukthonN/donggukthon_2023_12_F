package com.example.donggukton.data.repository

import com.example.donggukton.data.datasource.remote.AuthDataSource
import com.example.donggukton.data.model.request.LoginRequest
import com.example.donggukton.data.model.request.RequestDuplicatedId
import com.example.donggukton.data.model.request.RequestSignUp
import com.example.donggukton.data.model.response.ResponseSignUp
import com.example.donggukton.data.model.response.LoginResponse
import com.example.donggukton.data.model.response.ResponseDuplicatedId
import com.example.donggukton.domain.repository.AuthRepository
import retrofit2.Response
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
) : AuthRepository {
    override suspend fun login(loginRequest: LoginRequest): Result<LoginResponse> =
        runCatching {
            authDataSource.login(loginRequest)
        }

    override suspend fun signUp(requestSignUp: RequestSignUp): Result<Boolean> =
        runCatching {
            authDataSource.signUp(requestSignUp).success
        }

    override suspend fun checkDuplicatedId(userId: String): Result<Response<ResponseDuplicatedId>> =
        runCatching {
            authDataSource.checkDuplicatedId(RequestDuplicatedId(userId))
        }
}