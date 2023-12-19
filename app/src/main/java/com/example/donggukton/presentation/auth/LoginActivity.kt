package com.example.donggukton.presentation.auth

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityLoginBinding
import com.example.donggukton.presentation.home.HomeActivity
import com.example.donggukton.util.binding.BindingActivity
import com.example.donggukton.util.extension.showToast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class LoginActivity : BindingActivity<ActivityLoginBinding>(R.layout.activity_login) {
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
        binding.btnLogin.setOnClickListener {
            viewModel.login()
        }
    }

    private fun collectData() {
        viewModel.loginInfo.flowWithLifecycle(lifecycle).onEach { loginInfo ->
            if (loginInfo != null) {
                when (loginInfo.success) {
                    true -> {
                        showToast(getString(R.string.login_success_toast))
                        viewModel.setUserId(loginInfo.userId)
                        moveToHome()
                    }

                    false -> {
                        showToast(getString(R.string.login_failure_toast))
                    }
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun moveToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
