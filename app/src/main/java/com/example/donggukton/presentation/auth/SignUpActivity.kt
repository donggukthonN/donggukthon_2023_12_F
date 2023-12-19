package com.example.donggukton.presentation.auth

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivitySignUpBinding
import com.example.donggukton.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private val viewModel: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel
        addListeners()
        collectData()
    }

    private fun addListeners() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun collectData() {
        viewModel.isValidNickName.flowWithLifecycle(lifecycle).onEach { isValidNickName ->
            when (isValidNickName) {
                true -> {
                    with(binding) {
                        signUpNicknameTitle.setTextColor(getColor(R.color.black))
                        etSignUpNickname.backgroundTintList =
                            ColorStateList.valueOf(getColor(R.color.black))
                    }
                }

                false -> {
                    with(binding) {
                        signUpNicknameTitle.setTextColor(getColor(R.color.error))
                        etSignUpNickname.backgroundTintList =
                            ColorStateList.valueOf(getColor(R.color.error))
                    }
                }
            }
        }.launchIn(lifecycleScope)
        viewModel.isValidId.flowWithLifecycle(lifecycle).onEach { isValidId ->
            when (isValidId) {
                true -> {
                    with(binding) {
                        signUpIdTitle.setTextColor(getColor(R.color.black))
                        etSignUpId.backgroundTintList =
                            ColorStateList.valueOf(getColor(R.color.black))
                    }
                }

                false -> {
                    with(binding) {
                        signUpIdTitle.setTextColor(getColor(R.color.error))
                        etSignUpId.backgroundTintList =
                            ColorStateList.valueOf(getColor(R.color.error))
                    }
                }
            }
        }.launchIn(lifecycleScope)
        viewModel.isValidPassword.flowWithLifecycle(lifecycle).onEach { isValidPassword ->
            when (isValidPassword) {
                true -> {
                    with(binding) {
                        signUpPasswordTitle.setTextColor(getColor(R.color.black))
                        etSignUpPassword.backgroundTintList =
                            ColorStateList.valueOf(getColor(R.color.black))
                    }
                }

                false -> {
                    with(binding) {
                        signUpPasswordTitle.setTextColor(getColor(R.color.error))
                        etSignUpPassword.backgroundTintList =
                            ColorStateList.valueOf(getColor(R.color.error))
                    }
                }
            }
        }.launchIn(lifecycleScope)
        viewModel.isValidPasswordCheck.flowWithLifecycle(lifecycle).onEach { isValidPasswordCheck->
            when (isValidPasswordCheck) {
                true -> {
                    with(binding) {
                        signUpPasswordCheckTitle.setTextColor(getColor(R.color.black))
                        etSignUpPasswordCheck.backgroundTintList =
                            ColorStateList.valueOf(getColor(R.color.black))
                    }
                }

                false -> {
                    with(binding) {
                        signUpPasswordCheckTitle.setTextColor(getColor(R.color.error))
                        etSignUpPasswordCheck.backgroundTintList =
                            ColorStateList.valueOf(getColor(R.color.error))
                    }
                }
            }
        }.launchIn(lifecycleScope)
        viewModel.isValidSignUp.flowWithLifecycle(lifecycle).onEach { isValidSignUp ->
            binding.btnSignUp.isEnabled = isValidSignUp
        }.launchIn(lifecycleScope)
    }
}
