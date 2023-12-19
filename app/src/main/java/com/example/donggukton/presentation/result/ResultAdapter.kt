package com.example.donggukton.presentation.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.donggukton.databinding.ItemResultBinding
import com.example.donggukton.databinding.ItemResultCoverBinding
import com.example.donggukton.domain.model.result.Result
import com.example.donggukton.util.extension.ItemDiffCallback

class ResultAdapter() : ListAdapter<Result.Question, RecyclerView.ViewHolder>(
    ItemDiffCallback<Result.Question>(
        onItemsTheSame = { old, new -> old.questionNum == new.questionNum },
        onContentsTheSame = { old, new -> old == new },
    ),
) {

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_FIRST_ITEM else VIEW_TYPE_OTHER_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_FIRST_ITEM) {
            val binding =
                ItemResultCoverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            FirstItemViewHolder(binding)
        } else {
            val binding =
                ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ResultViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is FirstItemViewHolder -> holder.onBind(item)
            is ResultViewHolder -> holder.onBind(item)
        }
    }

    inner class FirstItemViewHolder(private val binding: ItemResultCoverBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Result.Question) {
        }
    }

    inner class ResultViewHolder(private val binding: ItemResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: Result.Question) {
            with(binding) {
                tvQuestionNum.text = String.format("No.%s", data.questionNum)
                tvQuestionTitle.text = data.question
                tvQuestionAnswer.text = data.answer
            }
        }
    }

    companion object {
        private const val VIEW_TYPE_FIRST_ITEM = 0
        private const val VIEW_TYPE_OTHER_ITEM = 1
    }
}
