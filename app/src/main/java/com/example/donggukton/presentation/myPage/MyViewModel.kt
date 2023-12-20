package com.example.donggukton.presentation.myPage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donggukton.data.datasource.local.DonggukStorage
import com.example.donggukton.data.model.response.ResponseMyInfo
import com.example.donggukton.domain.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val myRepository: MyRepository,
    private val localDataStorage: DonggukStorage
) : ViewModel() {
    private val _myInfo = MutableStateFlow<ResponseMyInfo?>(null)
    val myInfo get() = _myInfo.asStateFlow()

    init {
        getMyInfo()
    }

    private fun getMyInfo() {
        viewModelScope.launch {
            myRepository.getMyInfo(localDataStorage.userId)
                .onSuccess { myInfo ->
                    _myInfo.value = myInfo
                }.onFailure { throwable ->
                    Timber.e(throwable.message)
                }
        }
    }
}