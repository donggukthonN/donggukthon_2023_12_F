package com.example.donggukton.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(

) : ViewModel() {
    val nickName = MutableStateFlow("")
    val id = MutableStateFlow("")
    val password = MutableStateFlow("")
    val passwordCheck = MutableStateFlow("")

    val isValidNickName: StateFlow<Boolean> = nickName.map { nickName ->
        nickName.isEmpty() or nickName.matches(Regex(NICKNAME_PATTERN))
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), false)

    val isValidId: StateFlow<Boolean> = id.map { id ->
        id.isEmpty() or id.matches(Regex(ID_PATTERN))
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), false)

    val isValidPassword: StateFlow<Boolean> = password.map { password ->
        password.isEmpty() or password.matches(Regex(PASSWORD_PATTERN))
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), false)

    val isValidPasswordCheck: StateFlow<Boolean> =
        combine(password, passwordCheck) { password, passwordCheck ->
            passwordCheck.isEmpty() ||
            password == passwordCheck
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), false)

    val isValidSignUp: StateFlow<Boolean> =
        combine(
            isValidNickName,
            isValidId,
            isValidPassword,
            isValidPasswordCheck
        ) { isValidNickName, isValidId, isValidPassword, isValidPasswordCheck ->
            isValidNickName && isValidId && isValidPassword && isValidPasswordCheck
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), false)

    companion object {
        const val NICKNAME_PATTERN = "^[가-힣A-Za-z]{1,4}\$"
        const val ID_PATTERN = "^[A-Za-z0-9]{6,12}\$"
        const val PASSWORD_PATTERN =
            "^[A-Za-z0-9!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]{8,}$"
    }
}
