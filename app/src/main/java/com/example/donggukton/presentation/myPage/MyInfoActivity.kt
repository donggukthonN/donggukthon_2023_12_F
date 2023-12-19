package com.example.donggukton.presentation.myPage

import android.os.Bundle
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityMyInfoBinding
import com.example.donggukton.util.binding.BindingActivity

class MyInfoActivity: BindingActivity<ActivityMyInfoBinding>(R.layout.activity_my_info) {
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