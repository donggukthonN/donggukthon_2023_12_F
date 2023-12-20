package com.example.donggukton.data.datasource.remote

import com.example.donggukton.data.model.request.LoginRequest
import com.example.donggukton.data.model.request.RequestDuplicatedId
import com.example.donggukton.data.model.request.RequestSignUp
import com.example.donggukton.data.model.response.LoginResponse
import com.example.donggukton.data.model.response.ResponseDuplicatedId
import com.example.donggukton.data.model.response.ResponseSignUp
import com.example.donggukton.data.service.AuthService
import retrofit2.Response
import javax.inject.Inject

class AuthDataSource @Inject constructor(
    private val authService: AuthService
) {
    suspend fun login(loginRequest: LoginRequest): LoginResponse = authService.login(loginRequest)
    suspend fun signUp(requestSignUp: RequestSignUp): ResponseSignUp =
        authService.signUp(requestSignUp)

    suspend fun checkDuplicatedId(requestDuplicatedId: RequestDuplicatedId): Response<ResponseDuplicatedId> =
        authService.checkDuplicatedId(requestDuplicatedId)
}
