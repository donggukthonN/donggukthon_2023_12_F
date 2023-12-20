package com.example.donggukton.presentation.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.donggukton.databinding.ItemResultBinding
import com.example.donggukton.domain.model.result.ResultData
import com.example.donggukton.util.extension.ItemDiffCallback

class ResultAdapter() : ListAdapter<ResultData.Question, RecyclerView.ViewHolder>(
    ItemDiffCallback<ResultData.Question>(
        onItemsTheSame = { old, new -> old.questionNum == new.questionNum },
        onContentsTheSame = { old, new -> old == new },
    ),
) {

    fun submitFilteredData(data: List<ResultData.Question>) {
        val filteredData = data.filter { it.flag != null }
        submitList(filteredData)
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ResultViewHolder(binding)
        return ResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is ResultViewHolder -> holder.onBind(item)
        }
    }

    inner class ResultViewHolder(private val binding: ItemResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResultData.Question) {
            with(binding) {
                tvQuestionNum.text = String.format("No.%s", data.questionNum)
                tvQuestionTitle.text = data.question
                tvQuestionAnswer.text = data.answer
            }
        }
    }
}
