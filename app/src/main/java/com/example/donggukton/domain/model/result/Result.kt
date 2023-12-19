package com.example.donggukton.domain.model.result

data class Result(
    val userId: String,
    val questions: List<Question>,
) {

    data class Question(
        val questionNum: String,
        val question: String,
        val answer: String,
        val flag: Boolean,
    )
}
