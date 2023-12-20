package com.example.donggukton.domain.repository

import com.example.donggukton.data.model.request.LoginRequest
import com.example.donggukton.data.model.request.RequestSignUp
import com.example.donggukton.data.model.response.LoginResponse
import com.example.donggukton.data.model.response.ResponseDuplicatedId
import retrofit2.Response

interface AuthRepository {
    suspend fun login(loginRequest: LoginRequest): Result<LoginResponse>
    suspend fun signUp(requestSignUp: RequestSignUp): Result<Boolean>
    suspend fun checkDuplicatedId(userId: String): Result<Response<ResponseDuplicatedId>>
}
