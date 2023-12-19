package com.example.donggukton.presentation.question

import android.os.Bundle
import android.view.View
import com.example.donggukton.R
import com.example.donggukton.databinding.DialogCompletedAnswerBinding
import com.example.donggukton.util.binding.BindingDialogFragment

class CompletedAnswerDialogFragment :
    BindingDialogFragment<DialogCompletedAnswerBinding>(R.layout.dialog_completed_answer) {
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