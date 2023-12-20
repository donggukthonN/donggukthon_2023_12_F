package com.example.donggukton.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityHomeBinding
import com.example.donggukton.presentation.myPage.MyPageActivity
import com.example.donggukton.presentation.question.QuestionActivity
import com.example.donggukton.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListeners()
    }

    private fun addListeners() {
        binding.ivMypage.setOnClickListener {
            startActivity(Intent(this, MyPageActivity::class.java))
        }
        binding.ivQuestion.setOnClickListener {
            startActivity(Intent(this, InstructionActivity::class.java))
        }
        binding.tv13.setOnClickListener {
            moveToQuestion(13)
        }
        binding.tv14.setOnClickListener {
            moveToQuestion(14)
        }
        binding.tv15.setOnClickListener {
            moveToQuestion(15)
        }
        binding.tv16.setOnClickListener {
            moveToQuestion(16)
        }
        binding.tv17.setOnClickListener {
            moveToQuestion(17)
        }
        binding.tv18.setOnClickListener {
            moveToQuestion(18)
        }
        binding.tv19.setOnClickListener {
            moveToQuestion(19)
        }
        binding.tv20.setOnClickListener {
            moveToQuestion(20)
        }
        binding.tv21.setOnClickListener {
            moveToQuestion(21)
        }
        binding.tv22.setOnClickListener {
            moveToQuestion(22)
        }
        binding.tv23.setOnClickListener {
            moveToQuestion(23)
        }
        binding.tv24.setOnClickListener {
            moveToQuestion(24)
        }
        binding.tv25.setOnClickListener {
            moveToQuestion(25)
        }
    }

    private fun moveToQuestion(qId: Int) {
        val intent = Intent(this, QuestionActivity::class.java)
        intent.putExtra(QUESTION_NUM, qId)
        startActivity(intent)
    }

    companion object {
        const val QUESTION_NUM = "questionNum"
    }
}
