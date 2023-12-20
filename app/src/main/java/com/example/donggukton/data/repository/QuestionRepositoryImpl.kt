package com.example.donggukton.data.repository

import com.example.donggukton.data.datasource.remote.QuestionDataSource
import com.example.donggukton.data.model.request.RequestReplyAnswer
import com.example.donggukton.data.model.response.ResponseQuestion
import com.example.donggukton.data.model.response.ResponseReplyAnswer
import com.example.donggukton.domain.repository.QuestionRepository
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val questionDataSource: QuestionDataSource
) : QuestionRepository {
    override suspend fun getQuestion(uId: String, qId: Int): Result<ResponseQuestion> =
        runCatching {
            questionDataSource.getQuestion(uId, qId)
        }

    override suspend fun replyAnswer(
        requestReplyAnswer: RequestReplyAnswer,
        uId: String,
        qId: Int
    ): Result<ResponseReplyAnswer> =
        kotlin.runCatching {
            questionDataSource.replyAnswer(requestReplyAnswer, uId, qId)
        }
}