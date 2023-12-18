package com.example.donggukton.presentation

import android.os.Bundle
import com.example.donggukton.R
import com.example.donggukton.databinding.ActivityOnboardingBinding
import com.example.donggukton.util.binding.BindingActivity
import com.google.android.material.tabs.TabLayoutMediator

class OnBoardingActivity :
    BindingActivity<ActivityOnboardingBinding>(R.layout.activity_onboarding) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
    }

    private fun initLayout() {
        val adapter = OnBoardingAdapter()
        with(binding) {
            vpOnboarding.adapter = adapter
            TabLayoutMediator(tabOnboarding, vpOnboarding) {_, _ ->}.attach()
        }
    }
}