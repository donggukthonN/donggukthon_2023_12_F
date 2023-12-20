package com.example.donggukton.data.datasource.remote

import com.example.donggukton.data.model.request.RequestReplyAnswer
import com.example.donggukton.data.service.QuestionService
import javax.inject.Inject

class QuestionDataSource @Inject constructor(
    private val questionService: QuestionService
) {
    suspend fun getQuestion(uId: String, qId: Int) = questionService.getQuestion(uId, qId)
    suspend fun replyAnswer(requestReplyAnswer: RequestReplyAnswer, uId: String, qId: Int) =
        questionService.replyAnswer(requestReplyAnswer, uId, qId)
}
