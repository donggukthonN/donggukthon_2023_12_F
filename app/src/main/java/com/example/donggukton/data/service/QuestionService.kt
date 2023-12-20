package com.example.donggukton.data.service

import com.example.donggukton.data.model.request.RequestReplyAnswer
import com.example.donggukton.data.model.response.ResponseQuestion
import com.example.donggukton.data.model.response.ResponseReplyAnswer
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface QuestionService {
    @GET("{u_id}/question/{q_id}/")
    suspend fun getQuestion(
        @Path("u_id") u_id: String,
        @Path("q_id") q_id: Int
    ): ResponseQuestion

    @POST("{u_id}/question/{q_id}/answer/")
    suspend fun replyAnswer(
        @Body requestReplyAnswer: RequestReplyAnswer,
        @Path("u_id") u_id: String,
        @Path("q_id") q_id: Int
    ): ResponseReplyAnswer
}
