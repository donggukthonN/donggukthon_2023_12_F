package com.example.donggukton.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.donggukton.data.datasource.local.DonggukStorage
import com.example.donggukton.data.model.request.LoginRequest
import com.example.donggukton.data.model.request.RequestSignUp
import com.example.donggukton.data.model.response.LoginResponse
import com.example.donggukton.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val localDataSource: DonggukStorage
) : ViewModel() {
    val nickName = MutableStateFlow("")
    val id = MutableStateFlow("")
    val password = MutableStateFlow("")
    val passwordCheck = MutableStateFlow("")
    private val _loginInfo = MutableStateFlow<LoginResponse?>(null)
    val loginInfo get() = _loginInfo.asStateFlow()

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

    private val _signUpResult = MutableStateFlow<Boolean?>(null)
    val signUpResult get() = _signUpResult.asStateFlow()
    private val _duplicatedResult = MutableStateFlow<Boolean?>(null)
    val duplicatedResult get() = _duplicatedResult.asStateFlow()
    fun login() {
        viewModelScope.launch {
            authRepository.login(
                LoginRequest(
                    userId = id.value,
                    password = password.value
                )
            ).onSuccess { response ->
                _loginInfo.value = response
            }.onFailure { throwable ->
                Timber.d(throwable.message)
            }
        }
    }

    fun signUp() {
        viewModelScope.launch {
            authRepository.signUp(
                RequestSignUp(
                    userId = id.value,
                    nickname = nickName.value,
                    password = password.value
                )
            ).onSuccess { signUpResult ->
                _signUpResult.value = signUpResult
            }.onFailure { throwable ->
                Timber.d(throwable.message)
            }
        }
    }

    fun checkDuplicatedId() {
        viewModelScope.launch {
            authRepository.checkDuplicatedId(id.value)
                .onSuccess { response ->
                    if (response.code() == 200) {
                        _duplicatedResult.value = false
                    } else if (response.code() == 400) {
                        _duplicatedResult.value = true
                    }
                }.onFailure { throwable ->
                    Timber.d(throwable.message)
                }
        }
    }

    fun setDuplicatedResultNull() {
        _duplicatedResult.value = null
    }

    fun setUserId(userId: String) {
        localDataSource.userId = userId
    }

    companion object {
        const val NICKNAME_PATTERN = "^[가-힣A-Za-z]{1,4}\$"
        const val ID_PATTERN = "^[A-Za-z0-9]{6,12}\$"
        const val PASSWORD_PATTERN =
            "^[A-Za-z0-9!@#\$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?~`]{8,}$"
    }
}
