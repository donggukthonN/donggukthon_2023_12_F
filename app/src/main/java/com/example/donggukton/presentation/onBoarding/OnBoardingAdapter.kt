package com.example.donggukton.presentation.onBoarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.donggukton.databinding.ItemOnboardingBinding
import com.example.donggukton.presentation.type.OnBoardingViewType

class OnBoardingAdapter : RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    private val onBoardingList = OnBoardingViewType.values()

    class OnBoardingViewHolder(private val binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(onboarding: OnBoardingViewType) {
            binding.ivOnboardingImg.setImageDrawable(
                binding.root.context.getDrawable(onboarding.imageRes),
            )
            binding.tvOnboarding.text = binding.root.context.getString(onboarding.desRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder =
        OnBoardingViewHolder(
            ItemOnboardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
        )

    override fun getItemCount() = onBoardingList.size

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(onBoardingList[position])
    }
}
