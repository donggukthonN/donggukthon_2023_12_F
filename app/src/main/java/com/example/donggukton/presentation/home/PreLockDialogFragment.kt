package com.example.donggukton.presentation.home

import android.os.Bundle
import android.view.View
import com.example.donggukton.R
import com.example.donggukton.databinding.DialogPreLockBinding
import com.example.donggukton.util.binding.BindingDialogFragment

class PreLockDialogFragment :
    BindingDialogFragment<DialogPreLockBinding>(R.layout.dialog_pre_lock) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addListeners()
    }

    private fun addListeners() {
        binding.ivClose.setOnClickListener {
            dismiss()
        }
    }
}