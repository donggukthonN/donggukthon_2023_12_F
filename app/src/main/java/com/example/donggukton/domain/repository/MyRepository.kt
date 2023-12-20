package com.example.donggukton.domain.repository

import com.example.donggukton.data.model.response.ResponseMyInfo

interface MyRepository {
    suspend fun getMyInfo(uId: String) : Result<ResponseMyInfo>
}