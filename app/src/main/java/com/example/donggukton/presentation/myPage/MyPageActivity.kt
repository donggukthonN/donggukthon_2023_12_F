package com.example.donggukton.presentation.myPage

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityMyPageBinding
import com.example.donggukton.presentation.addFriend.AddFriendActivity
import com.example.donggukton.presentation.result.ResultActivity
import com.example.donggukton.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MyPageActivity : BindingActivity<ActivityMyPageBinding>(R.layout.activity_my_page) {
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        collectData()
        addListeners()
    }

    private fun addListeners() {
        binding.btnMyInfo.setOnClickListener {
            startActivity(Intent(this, MyInfoActivity::class.java))
        }
        binding.btnMyResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra(MY, MY)
            }
            startActivity(intent)
        }
        binding.btnMyAddFriend.setOnClickListener {
            startActivity(Intent(this, AddFriendActivity::class.java))
        }
        binding.ivBack.setOnClickListener {
            finish()
        }
    }

    private fun collectData() {
        viewModel.myInfo.flowWithLifecycle(lifecycle).onEach { myInfo ->
            if (myInfo != null) {
                binding.tvMyPageTitle.text =
                    getString(R.string.name_title, myInfo.nickname)
                binding.btnMyResult.text =
                    getString(R.string.my_page_finished_version_title, myInfo.nickname)
            }
        }.launchIn(lifecycleScope)
    }

    companion object {
        const val MY = "my"
    }
}
