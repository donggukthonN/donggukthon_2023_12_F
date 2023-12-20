package com.example.donggukton.domain.repository

import com.example.donggukton.domain.model.result.ResultData

interface ResultRepository {

    suspend fun getMyResult(u_id: String): Result<ResultData>

    suspend fun getFriendResult(u_id: String, f_id: String): Result<ResultData>
}
