package com.example.donggukton.domain.repository

import com.example.donggukton.data.model.request.RequestReplyAnswer
import com.example.donggukton.data.model.response.ResponseQuestion
import com.example.donggukton.data.model.response.ResponseReplyAnswer

interface QuestionRepository {
    suspend fun getQuestion(uId: String, qId: Int): Result<ResponseQuestion>
    suspend fun replyAnswer(requestReplyAnswer: RequestReplyAnswer, uId: String, qId: Int) : Result<ResponseReplyAnswer>
}
