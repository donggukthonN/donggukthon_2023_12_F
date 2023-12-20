package com.example.donggukton.presentation.addFriend

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donggukton.data.datasource.local.DonggukStorage
import com.example.donggukton.data.model.request.RequestAddFriendDto
import com.example.donggukton.domain.model.result.FriendList
import com.example.donggukton.domain.repository.FriendRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AddFriendViewModel @Inject constructor(
    private val friendRepository: FriendRepository,
    private val localDataSource: DonggukStorage,
) : ViewModel() {

    private val _friendListData = MutableLiveData<List<FriendList.FriendData>>()
    val friendListData: LiveData<List<FriendList.FriendData>> get() = _friendListData

    private val _postFriend = MutableLiveData(false)
    val postFriend: LiveData<Boolean> get() = _postFriend

    private val _errorData = MutableLiveData(false)
    val errorData: LiveData<Boolean> get() = _errorData

    init {
        getFriendList()
    }

    fun postFriend(f_id: String, code: Int) {
        viewModelScope.launch {
            friendRepository.postFriend(
                localDataSource.userId,
                RequestAddFriendDto(
                    f_id = f_id,
                    code = code,
                ),
            ).onSuccess { data ->
                _postFriend.value = true
                Log.d("aaa", "${_errorData.value}")
            }.onFailure { throwable ->
                _errorData.value = true
                Log.d("aaa", throwable.message.toString())
            }
        }
    }

    fun getFriendList() {
        viewModelScope.launch {
            friendRepository.getFriendList(
                localDataSource.userId,
            ).onSuccess { friendData ->
                _friendListData.value = friendData.friends
            }.onFailure { throwable ->
                Timber.e("통신실패")
            }
        }
    }

    fun deleteFriend(f_id: String) {
        viewModelScope.launch {
            friendRepository.deleteFriend(localDataSource.userId, f_id)
        }
    }
}
