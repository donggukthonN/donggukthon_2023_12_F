package com.example.donggukton.presentation.myPage

import android.content.Intent
import android.os.Bundle
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityMyPageBinding
import com.example.donggukton.presentation.addFriend.AddFriendActivity
import com.example.donggukton.util.binding.BindingActivity

class MyPageActivity : BindingActivity<ActivityMyPageBinding>(R.layout.activity_my_page) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListeners()
    }

    private fun addListeners() {
        binding.btnMyInfo.setOnClickListener {
            startActivity(Intent(this, MyInfoActivity::class.java))
        }
        binding.btnMyResult.setOnClickListener {
            // 내 완성본으로 이동
        }
        binding.btnMyAddFriend.setOnClickListener {
            startActivity(Intent(this, AddFriendActivity::class.java))
        }
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}
