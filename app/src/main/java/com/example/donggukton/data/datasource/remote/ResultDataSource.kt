package com.example.donggukton.data.datasource.remote

import com.example.donggukton.data.model.response.ResponseResultDto
import com.example.donggukton.data.service.ResultService
import javax.inject.Inject

class ResultDataSource @Inject constructor(
    private val resultService: ResultService,
) {
    suspend fun getMyResult(u_id: String): ResponseResultDto =
        resultService.getMyResult(u_id)

    suspend fun getFriendResult(u_id: String, f_id: String): ResponseResultDto =
        resultService.getFriendResult(u_id, f_id)
}
