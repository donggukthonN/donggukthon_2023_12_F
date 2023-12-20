package com.example.donggukton.presentation.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.donggukton.databinding.ItemResultCoverBinding

class ResultCoverAdapter() : RecyclerView.Adapter<ResultCoverAdapter.ResultCoverViewHolder>() {

    override fun getItemCount(): Int = 1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ResultCoverAdapter.ResultCoverViewHolder {
        val binding =
            ItemResultCoverBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ResultCoverViewHolder(binding)
        return ResultCoverViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultCoverViewHolder, position: Int) {
        holder.onBind()
    }

    inner class ResultCoverViewHolder(private val binding: ItemResultCoverBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() {
        }
    }
}
