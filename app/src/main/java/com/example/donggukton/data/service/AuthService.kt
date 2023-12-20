package com.example.donggukton.data.service

import com.example.donggukton.data.model.request.LoginRequest
import com.example.donggukton.data.model.request.RequestDuplicatedId
import com.example.donggukton.data.model.request.RequestSignUp
import com.example.donggukton.data.model.response.LoginResponse
import com.example.donggukton.data.model.response.ResponseDuplicatedId
import com.example.donggukton.data.model.response.ResponseSignUp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("login/")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse

    @POST("signup/")
    suspend fun signUp(@Body requestSignUp: RequestSignUp): ResponseSignUp

    @POST("signup/duplicate/")
    suspend fun checkDuplicatedId(@Body requestDuplicatedId: RequestDuplicatedId): Response<ResponseDuplicatedId>
}
