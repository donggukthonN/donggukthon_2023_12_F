package com.example.donggukton.domain.model.result

data class ResultData(
    val userId: String,
    val questions: List<Question>,
) {
    data class Question(
        val questionNum: Int,
        val question: String,
        val answer: String?,
        val flag: Int?,
    )
}
