package com.example.donggukton.presentation.auth

import android.os.Bundle
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivitySignUpBinding
import com.example.donggukton.util.binding.BindingActivity

class SignUpActivity: BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListeners()
    }

    private fun addListeners(){
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}
