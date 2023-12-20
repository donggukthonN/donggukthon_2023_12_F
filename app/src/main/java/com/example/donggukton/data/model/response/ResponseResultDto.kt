package com.example.donggukton.data.model.response

import com.example.donggukton.domain.model.result.ResultData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseResultDto(
    @SerialName("questions")
    val questions: List<Question>,
    @SerialName("userId")
    val userId: String,
) {
    @Serializable
    data class Question(
        @SerialName("answer")
        val answer: String?,
        @SerialName("flag")
        val flag: Int?,
        @SerialName("question")
        val question: String,
        @SerialName("questionNum")
        val questionNum: Int,
    )

    fun toResult() = ResultData(
        questions = questions.map { question ->
            ResultData.Question(
                answer = question.answer,
                flag = question.flag,
                question = question.question,
                questionNum = question.questionNum,
            )
        },
        userId = userId,
    )
}
