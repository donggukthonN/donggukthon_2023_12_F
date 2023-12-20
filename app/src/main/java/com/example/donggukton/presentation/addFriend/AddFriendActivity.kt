package com.example.donggukton.presentation.addFriend

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityAddFriendBinding
import com.example.donggukton.presentation.result.ResultActivity
import com.example.donggukton.util.binding.BindingActivity
import com.example.donggukton.util.extension.setOnSingleClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddFriendActivity : BindingActivity<ActivityAddFriendBinding>(R.layout.activity_add_friend) {

    private val addFriendViewModel by viewModels<AddFriendViewModel>()

    private val addFriendAdapter by lazy {
        AddFriendAdapter(
            onClick = { id, name ->
                moveToFriendResult(id, name)
            },
            deleteFriend = { id ->
                deleteFriend(id)
            },
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        observeFriendList()
        addFriend()
        addListeners()
        observePostFriend()
        observeDialog()
    }

    private fun observeDialog() {
        addFriendViewModel.errorData.observe(this) { error ->
            if (error) {
                Log.d("aaa", "$error")
                val fragment = ErrorDialogFragment()
                fragment.show(supportFragmentManager, fragment.tag)
            }
        }
    }

    private fun addListeners() {
        binding.ivAddFriendBack.setOnClickListener {
            finish()
        }
    }

    private fun addFriend() {
        binding.btnDone.setOnSingleClickListener {
            val friendId = binding.etAddFriendId.text.toString()
            val code = binding.etAddFriendCode.text.toString().toInt()
            if (friendId.isNotEmpty() && binding.etAddFriendCode.text.isNotEmpty()) {
                addFriendViewModel.postFriend(friendId, code)
            }
        }
    }

    private fun observePostFriend() {
        addFriendViewModel.postFriend.observe(this) { isSuccess ->
            if (isSuccess) {
                fetch()
            }
        }
    }

    private fun deleteFriend(f_id: String) {
        addFriendViewModel.deleteFriend(f_id)
        fetch()
    }

    private fun fetch() {
        addFriendViewModel.getFriendList()
    }

    private fun observeFriendList() {
        addFriendViewModel.friendListData.observe(this) { data ->
            binding.rvFriendList.adapter = addFriendAdapter
            addFriendAdapter.submitList(data)
        }
    }

    private fun moveToFriendResult(id: String, name: String) {
        val intent = Intent(this, ResultActivity::class.java).apply {
            putExtra(FRIEND_LIST, id)
            putExtra(FRIEND_NAME, name)
            putExtra(FRIEND, "fff")
        }
        startActivity(intent)
    }

    companion object {
        const val FRIEND_LIST = "friend"
        const val FRIEND = "ffff"
        const val FRIEND_NAME = "name"
    }
}
