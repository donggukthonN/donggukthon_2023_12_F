package com.example.donggukton.presentation.addFriend

import android.os.Bundle
import android.view.View
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityAddFriendBinding
import com.example.donggukton.util.ChipFactory
import com.example.donggukton.util.binding.BindingActivity
import com.google.android.material.chip.Chip

class AddFriendActivity : BindingActivity<ActivityAddFriendBinding>(R.layout.activity_add_friend) {

    private val String.toChip: Chip
        get() = ChipFactory.create(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setMyFailTag() {
        val chip = binding.etAddFriend.text.toString().toChip.apply {
            id = View.generateViewId() // 각 Chip에 고유한 ID 부여, TS
            text = String.format("# %s", getString(i.titleRes))
        }
        binding.chipGroupMyFailTag.addView(chip)

    }
}
