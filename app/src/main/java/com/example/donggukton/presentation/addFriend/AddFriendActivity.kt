package com.example.donggukton.presentation.addFriend

import android.os.Bundle
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityAddFriendBinding
import com.example.donggukton.util.binding.BindingActivity

class AddFriendActivity : BindingActivity<ActivityAddFriendBinding>(R.layout.activity_add_friend) {

//    private val addFriendAdapter by lazy {
//        AddFriendAdapter(
//            onClick = moveToFriendResult(),
//        )
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding.rvFriendList.adapter = addFriendAdapter
//        addFriendAdapter.submitList()
    }

//    private fun moveToFriendResult(): (Int) -> Unit {
//        return { position ->
//            val intent = Intent(this, ResultActivity::class.java)
//            val profileList = addFriendViewModel.friendData.value
//            intent.putExtra(FRIEND_LIST, profileList?.get(position) as Parcelable)
//            startActivity(intent)
//        }
//    }

    companion object {
        const val FRIEND_LIST = "friend"
    }
}
