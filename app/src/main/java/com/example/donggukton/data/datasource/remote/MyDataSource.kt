package com.example.donggukton.data.datasource.remote

import com.example.donggukton.data.service.MyService
import javax.inject.Inject

class MyDataSource @Inject constructor(
    private val myService: MyService
) {
    suspend fun getMyInfo(uId: String) = myService.getMyProfile(uId)
}
