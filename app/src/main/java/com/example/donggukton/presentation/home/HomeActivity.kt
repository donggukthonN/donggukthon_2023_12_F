package com.example.donggukton.presentation.home

import android.content.Intent
import android.os.Bundle
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityHomeBinding
import com.example.donggukton.presentation.myPage.MyPageActivity
import com.example.donggukton.util.binding.BindingActivity

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListeners()
    }

    private fun addListeners() {
        binding.ivMypage.setOnClickListener {
            startActivity(Intent(this, MyPageActivity::class.java))
        }
        binding.ivQuestion.setOnClickListener {
            startActivity(Intent(this, InstructionActivity::class.java))
        }
    }
}
