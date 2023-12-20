package com.example.donggukton.presentation.question

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityQuestionBinding
import com.example.donggukton.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlin.properties.Delegates

@AndroidEntryPoint
class QuestionActivity : BindingActivity<ActivityQuestionBinding>(R.layout.activity_question) {
    private val viewModel: QuestionViewModel by viewModels()
    var qId by Delegates.notNull<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.viewModel = viewModel
        qId = intent.getIntExtra(QUESTION_NUM, -1)
        viewModel.getAnswerResult(qId)

        initLayout()
        addListeners()
        collectData()
    }

    private fun initLayout() {
        binding.tvQuestionNum.text = getString(R.string.question_num, qId)
    }

    private fun addListeners() {
        binding.btnQuestionDone.setOnClickListener {
            showConfirmAnswerDialogFragment()
        }
        binding.ivQuestionBack.setOnClickListener {
            finish()
        }
        binding.cbQuestionPrivate.setOnClickListener {
            viewModel.setIsPublic(binding.cbQuestionPrivate.isChecked)
        }
    }

    private fun collectData() {
        viewModel.question.flowWithLifecycle(lifecycle).onEach { question ->
            binding.tvQuestionTitle.text = question
        }.launchIn(lifecycleScope)
        viewModel.replyAnswer.flowWithLifecycle(lifecycle).onEach {
            if (it == true) {
                finish()
            }
        }.launchIn(lifecycleScope)
        viewModel.answerResult.flowWithLifecycle(lifecycle).onEach { answerResult ->
            if (answerResult != null) {
                binding.tvQuestionTitle.text = answerResult.question
                binding.tvQuestionAnswer.text = answerResult.answer
                binding.tvQuestionAnswer.visibility = View.VISIBLE
                binding.etQuestionAnswer.visibility = View.INVISIBLE
            }
        }.launchIn(lifecycleScope)
    }

    private fun showConfirmAnswerDialogFragment() {
        val fragment = ConfirmAnswerDialogFragment()
        val bundle = Bundle()
        bundle.putInt(QUESTION_NUM, qId)
        fragment.arguments = bundle
        fragment.show(supportFragmentManager, fragment.tag)
    }

    companion object {
        const val QUESTION_NUM = "questionNum"
    }
}