package com.example.donggukton.presentation.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donggukton.data.datasource.local.DonggukStorage
import com.example.donggukton.domain.model.result.ResultData
import com.example.donggukton.domain.repository.ResultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(
    private val resultRepository: ResultRepository,
    private val localDataSource: DonggukStorage,
) : ViewModel() {

    private val _resultMyData = MutableLiveData<List<ResultData.Question>>()
    val resultMyData: LiveData<List<ResultData.Question>> get() = _resultMyData

    private val _resultFriendData = MutableLiveData<List<ResultData.Question>>()
    val resultFriendData: LiveData<List<ResultData.Question>> get() = _resultFriendData

    fun getMyResult() {
        viewModelScope.launch {
            resultRepository.getMyResult(
                localDataSource.userId,
            ).onSuccess { myResult ->
                _resultMyData.value = myResult.questions
            }.onFailure { throwable ->
                Timber.e("통신실패")
            }
        }
    }

    fun getFriendResult(f_id: String) {
        viewModelScope.launch {
            resultRepository.getFriendResult(
                localDataSource.userId,
                f_id,
            ).onSuccess { friendResult ->
                _resultFriendData.value = friendResult.questions
            }.onFailure { throwable ->
                Timber.e("통신실패")
            }
        }
    }
}
