package com.example.donggukton.presentation.question

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donggukton.data.datasource.local.DonggukStorage
import com.example.donggukton.data.model.request.RequestReplyAnswer
import com.example.donggukton.domain.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    private val questionRepository: QuestionRepository,
    private val localDataStore: DonggukStorage
) : ViewModel() {
    val answer = MutableStateFlow("")
    private val _question = MutableStateFlow("")
    val question get() = _question.asStateFlow()
    private val _isPrivate = MutableStateFlow(1)
    val isPrivate get() = _isPrivate.asStateFlow()
    private val _replyAnswer = MutableStateFlow<Boolean?>(null)
    val replyAnswer get() = _replyAnswer.asStateFlow()

    fun getQuestion(qId: Int) {
        viewModelScope.launch {
            questionRepository.getQuestion(
                uId = localDataStore.userId,
                qId = qId
            ).onSuccess { question ->
                _question.value = question.content
            }.onFailure { throwable ->
                Timber.d(throwable.message)
            }
        }
    }

    fun replyAnswer(qId: Int) {
        viewModelScope.launch {
            questionRepository.replyAnswer(
                RequestReplyAnswer(answer.value, isPrivate.value),
                uId = localDataStore.userId,
                qId = qId,
            ).onSuccess { success ->
                _replyAnswer.value = success.success
            }.onFailure { throwable ->
                Timber.d(throwable.message)
            }
        }
    }

    fun setIsPublic(isPrivate: Boolean) {
        if (isPrivate) _isPrivate.value = 1
        else _isPrivate.value = 0
    }
}