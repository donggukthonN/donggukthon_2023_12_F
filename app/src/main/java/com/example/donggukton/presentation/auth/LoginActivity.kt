package com.example.donggukton.presentation.auth

import android.os.Bundle
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityLoginBinding
import com.example.donggukton.util.binding.BindingActivity

class LoginActivity : BindingActivity<ActivityLoginBinding>(R.layout.activity_login) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListeners()
    }

    private fun addListeners() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}
