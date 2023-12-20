package com.example.donggukton.presentation.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityHomeBinding
import com.example.donggukton.presentation.myPage.MyPageActivity
import com.example.donggukton.presentation.myPage.MyViewModel
import com.example.donggukton.presentation.question.QuestionActivity
import com.example.donggukton.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.LocalDate
import kotlin.properties.Delegates

@AndroidEntryPoint
class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val myViewModel: MyViewModel by viewModels()
    var dayCount by Delegates.notNull<Int>()
    val today = LocalDate.now().dayOfMonth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        collectData()
        addListeners()
    }

    private fun collectData() {
        myViewModel.myInfo.flowWithLifecycle(lifecycle).onEach { myInfo ->
            if (myInfo != null) {
                binding.tvHomeTitle.text =
                    getString(R.string.name_title, myInfo.nickname)

                val startDate =
                    myInfo.startDate.substring(myInfo.startDate.length - 2, myInfo.startDate.length)
                dayCount = today - startDate.toInt() + 1
                Log.e("aaa", dayCount.toString())
            }
        }.launchIn(lifecycleScope)
    }

    private fun addListeners() {
        binding.ivMypage.setOnClickListener {
            startActivity(Intent(this, MyPageActivity::class.java))
        }
        binding.ivQuestion.setOnClickListener {
            startActivity(Intent(this, InstructionActivity::class.java))
        }
        binding.tv13.setOnClickListener {
            setCalender(13)
        }
        binding.tv14.setOnClickListener {
            setCalender(14)
        }
        binding.tv15.setOnClickListener {
            setCalender(15)
        }
        binding.tv16.setOnClickListener {
            setCalender(16)
        }
        binding.tv17.setOnClickListener {
            setCalender(17)
        }
        binding.tv18.setOnClickListener {
            setCalender(18)
        }
        binding.tv19.setOnClickListener {
            setCalender(19)
        }
        binding.tv20.setOnClickListener {
            setCalender(20)
        }
        binding.tv21.setOnClickListener {
            setCalender(21)
        }
        binding.tv22.setOnClickListener {
            setCalender(22)
        }
        binding.tv23.setOnClickListener {
            setCalender(23)
        }
        binding.tv24.setOnClickListener {
            setCalender(24)
        }
        binding.tv25.setOnClickListener {
            setCalender(25)
        }
    }

    // TODO 네이밍 작성
    private fun setCalender(dayNum: Int) {
        if (dayNum < dayCount - 2) {
            PreLockDialogFragment().show(supportFragmentManager, PreLockDialogFragment().tag)
        } else if (dayNum > dayCount) {
            val fragment = PostLockDialogFragment()
            val bundle = Bundle()
            bundle.putInt(REST_OF_DAY, dayNum - today)
            fragment.arguments = bundle
            fragment.show(supportFragmentManager, fragment.tag)
        } else {
            moveToQuestion(dayNum)
        }
    }

    private fun moveToQuestion(qId: Int) {
        val intent = Intent(this, QuestionActivity::class.java)
        intent.putExtra(QUESTION_NUM, qId)
        startActivity(intent)
    }

    companion object {
        const val QUESTION_NUM = "questionNum"
        const val REST_OF_DAY = "restOfDay"
    }
}
