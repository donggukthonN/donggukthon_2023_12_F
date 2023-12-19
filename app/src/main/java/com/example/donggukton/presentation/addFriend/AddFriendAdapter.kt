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
) : ListAdapter<Friend, AddFriendAdapter.AddFriendViewHolder>(
    ItemDiffCallback<Friend>(
        onItemsTheSame = { old, new -> old.id == new.id },
        onContentsTheSame = { old, new -> old == new },
    ),
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddFriendViewHolder {
        val binding = ItemFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AddFriendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AddFriendViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class AddFriendViewHolder(private val binding: ItemFriendBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: Friend) {
            binding.tvItemName.text = data.id
            binding.tvItemGotoFriend.setOnSingleClickListener {
                onClick(absoluteAdapterPosition)
            }
        }
    }
}
