package com.example.donggukton.presentation.result

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.example.donggukton.R
import com.example.donggukton.data.datasource.local.DonggukStorage
import com.example.donggukton.databinding.ActivityResultBinding
import com.example.donggukton.presentation.addFriend.AddFriendActivity.Companion.FRIEND_LIST
import com.example.donggukton.presentation.addFriend.AddFriendActivity.Companion.FRIEND_NAME
import com.example.donggukton.presentation.myPage.MyPageActivity.Companion.MY
import com.example.donggukton.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultActivity : BindingActivity<ActivityResultBinding>(R.layout.activity_result) {

    private val resultViewModel by viewModels<ResultViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupData()
        observeResult()
        addListeners()
    }

    private fun setupData() {
        if (intent.getStringExtra(MY).isNullOrEmpty()) {
            fetchFriend()
        } else {
            fetchMy()
        }
    }

    private fun addListeners() {
        binding.ivResultBack.setOnClickListener {
            finish()
        }
    }

    private fun observeResult() {
        val resultAdapter = ResultAdapter()
        val resultCoverAdapter = ResultCoverAdapter()
        val concatAdapter = ConcatAdapter(resultCoverAdapter, resultAdapter)

        resultViewModel.resultMyData.observe(this) { data ->
            resultAdapter.submitFilteredData(data)
            binding.tvResultTitle.text =
                String.format("%s 님의 Q_feed", DonggukStorage(this).userName)
        }

        resultViewModel.resultFriendData.observe(this) { data ->
            resultAdapter.submitFilteredData(data)
            binding.tvResultTitle.text =
                String.format("%s 님의 Q_feed", intent.getStringExtra(FRIEND_NAME))
        }

        binding.vpResult.adapter = concatAdapter
    }

    private fun fetchMy() {
        resultViewModel.getMyResult()
    }

    private fun fetchFriend() {
        val friendId = intent.getStringExtra(FRIEND_LIST)
        resultViewModel.getFriendResult(friendId.toString())
    }
}
