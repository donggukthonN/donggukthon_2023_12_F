package com.example.donggukton.data.repository

import com.example.donggukton.data.datasource.remote.MyDataSource
import com.example.donggukton.data.model.response.ResponseMyInfo
import com.example.donggukton.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImpl @Inject constructor(
    private val myDataSource: MyDataSource
) : MyRepository {
    override suspend fun getMyInfo(uId: String): Result<ResponseMyInfo> =
        runCatching {
            myDataSource.getMyInfo(uId)
        }
}
