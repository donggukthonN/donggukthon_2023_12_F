package com.example.donggukton.presentation.question

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.activityViewModels
import com.example.donggukton.R
import com.example.donggukton.databinding.DialogConfirmAnswerBinding
import com.example.donggukton.util.binding.BindingDialogFragment
import kotlin.properties.Delegates

class ConfirmAnswerDialogFragment :
    BindingDialogFragment<DialogConfirmAnswerBinding>(R.layout.dialog_confirm_answer) {
    private val viewModel: QuestionViewModel by activityViewModels()
    var qId by Delegates.notNull<Int>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        qId = arguments?.getInt(QUESTION_NUM) ?: -1
        addListeners()
    }

    private fun addListeners(){
        binding.ivClose.setOnClickListener {
            dismiss()
        }
        binding.btnAnswerConfirmCheck.setOnClickListener {
            viewModel.replyAnswer(qId)
        }
    }

    companion object {
        const val QUESTION_NUM = "questionNum"
    }
}