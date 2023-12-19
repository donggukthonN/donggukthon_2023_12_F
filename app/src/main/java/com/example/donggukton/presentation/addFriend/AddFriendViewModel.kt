package com.example.donggukton.presentation.addFriend

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donggukton.domain.model.result.FriendList
import com.example.donggukton.domain.repository.FriendRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AddFriendViewModel @Inject constructor(
    private val friendRepository: FriendRepository,
) : ViewModel() {

    private val _friendListData = MutableLiveData<List<FriendList.FriendData>>()
    val friendListData: LiveData<List<FriendList.FriendData>> get() = _friendListData

    fun getFriendList(u_id: String) {
        viewModelScope.launch {
            friendRepository.getFriendList(
                u_id,
            ).onSuccess { friendData ->
                _friendListData.value = friendData.friends
            }.onFailure { throwable ->
                Timber.e("통신실패")
            }
        }
    }

    fun deleteFriend(u_id: String, f_id: String) {
        viewModelScope.launch {
            friendRepository.deleteFriend(u_id, f_id)
        }
    }
}
