package com.example.donggukton.data.repository

import com.example.donggukton.data.datasource.remote.ResultDataSource
import com.example.donggukton.domain.model.result.ResultData
import com.example.donggukton.domain.repository.ResultRepository
import javax.inject.Inject

class ResultRepositoryImpl @Inject constructor(
    private val resultDataSource: ResultDataSource,
) : ResultRepository {

    override suspend fun getMyResult(u_id: String): Result<ResultData> =
        runCatching { resultDataSource.getMyResult(u_id).toResult() }

    override suspend fun getFriendResult(u_id: String, f_id: String): Result<ResultData> =
        runCatching { resultDataSource.getFriendResult(u_id, f_id).toResult() }
}
