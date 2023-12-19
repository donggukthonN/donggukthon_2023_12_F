package com.example.donggukton.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.donggukton.R

enum class OnBoardingViewType(
    @DrawableRes val imageRes: Int,
    @StringRes val desRes: Int,
) {
    FIRST(
        R.drawable.img_onboarding_2,
        R.string.onBoarding_des_2,
    ),
    SECOND(
        R.drawable.img_onboarding_2,
        R.string.onBoarding_des_2,
    ),
    THIRD(
        R.drawable.img_onboarding_3,
        R.string.onBoarding_des_3,
    ),
    FOURTH(
        R.drawable.img_onboarding_4,
        R.string.onBoarding_des_4,
    ),
}
