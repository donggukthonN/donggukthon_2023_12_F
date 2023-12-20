package com.example.donggukton.presentation.myPage

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityMyInfoBinding
import com.example.donggukton.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MyInfoActivity : BindingActivity<ActivityMyInfoBinding>(R.layout.activity_my_info) {
    private val viewModel: MyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        collectData()
        addListeners()
    }

    private fun collectData() {
        viewModel.myInfo.flowWithLifecycle(lifecycle).onEach { myInfo ->
            if (myInfo != null) {
                binding.tvMyInfoId.text =
                    getString(R.string.my_info_id, myInfo.userId)
                binding.tvMyInfoRegisterDate.text =
                    getString(R.string.my_info_start_date, myInfo.startDate)
                binding.tvMyInfoCode.text =
                    getString(R.string.my_info_code, myInfo.code)
            }
        }.launchIn(lifecycleScope)
    }

    private fun addListeners() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}