package com.example.donggukton.presentation.addFriend

import android.os.Bundle
import android.view.View
import com.example.donggukton.R
import com.example.donggukton.databinding.DialogNoIdBinding
import com.example.donggukton.util.binding.BindingDialogFragment

class ErrorDialogFragment :
    BindingDialogFragment<DialogNoIdBinding>(R.layout.dialog_no_id) {
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
