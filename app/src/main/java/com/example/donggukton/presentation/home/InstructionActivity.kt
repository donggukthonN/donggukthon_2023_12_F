package com.example.donggukton.presentation.home

import android.os.Bundle
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityInstructionBinding
import com.example.donggukton.util.binding.BindingActivity

class InstructionActivity :
    BindingActivity<ActivityInstructionBinding>(R.layout.activity_instruction) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addListeners()
    }

    private fun addListeners() {
        binding.ivBack.setOnClickListener {
            finish()
        }
    }
}