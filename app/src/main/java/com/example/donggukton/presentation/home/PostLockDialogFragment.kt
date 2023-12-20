package com.example.donggukton.presentation.home

import android.os.Bundle
import android.view.View
import com.example.donggukton.R
import com.example.donggukton.databinding.DialogPostLockBinding
import com.example.donggukton.util.binding.BindingDialogFragment
import kotlin.properties.Delegates

class PostLockDialogFragment :
    BindingDialogFragment<DialogPostLockBinding>(R.layout.dialog_post_lock) {
    var restOfDay by Delegates.notNull<Int>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        restOfDay = arguments?.getInt(REST_OF_DAY) ?: -1
        initLayout()
        addListeners()
    }

    private fun initLayout() {
        binding.tvPostDes.text = getString(R.string.dialog_post_lock, restOfDay)
    }

    private fun addListeners() {
        binding.ivClose.setOnClickListener {
            dismiss()
        }
    }

    companion object {
        const val REST_OF_DAY = "restOfDay"
    }
}