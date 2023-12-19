package com.example.donggukton.presentation.addFriend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.donggukton.databinding.ItemFriendBinding
import com.example.donggukton.domain.model.result.Friend
import com.example.donggukton.util.extension.ItemDiffCallback
import com.example.donggukton.util.extension.setOnSingleClickListener

class AddFriendAdapter(
    private val onClick: (Int) -> Unit,
) : ListAdapter<Friend, AddFriendAdapter.HistoryViewHolder>(
    ItemDiffCallback<Friend>(
        onItemsTheSame = { old, new -> old == new },
        onContentsTheSame = { old, new -> old == new },
    ),
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class HistoryViewHolder(private val binding: ItemFriendBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: Friend) {
            binding.tvItemName.text = data.id
            binding.tvItemGotoFriend.setOnSingleClickListener {
                onClick(absoluteAdapterPosition)
            }
        }
    }
}
