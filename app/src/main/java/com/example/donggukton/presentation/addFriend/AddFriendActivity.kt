package com.example.donggukton.presentation.addFriend

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.donggukton.R
import com.example.donggukton.data.datasource.local.DonggukStorage
import com.example.donggukton.databinding.ActivityAddFriendBinding
import com.example.donggukton.presentation.result.ResultActivity
import com.example.donggukton.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFriendActivity : BindingActivity<ActivityAddFriendBinding>(R.layout.activity_add_friend) {

    private val addFriendViewModel by viewModels<AddFriendViewModel>()
    private lateinit var donggukStorage: DonggukStorage

    private val addFriendAdapter by lazy {
        AddFriendAdapter(
            onClick = { id ->
                moveToFriendResult(id)
            },
            deleteFriend = { id ->
                deleteFriend(id)
            },
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetch()
        observeFriendList()
    }

    private fun deleteFriend(f_id: String) {
        addFriendViewModel.deleteFriend("adfa", f_id)
        fetch()
    }

    private fun fetch() {
        addFriendViewModel.getFriendList("afa")
    }

    private fun observeFriendList() {
        addFriendViewModel.friendListData.observe(this) { data ->
            binding.rvFriendList.adapter = addFriendAdapter
            addFriendAdapter.submitList(data)
        }
    }

    private fun moveToFriendResult(id: String) {
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra(FRIEND_LIST, id)
        }
        startActivity(intent)
    }

    companion object {
        const val FRIEND_LIST = "friend"
    }
}
