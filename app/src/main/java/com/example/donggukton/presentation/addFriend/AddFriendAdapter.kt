package com.example.donggukton.presentation.addFriend

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.donggukton.databinding.ItemFriendBinding
import com.example.donggukton.domain.model.result.FriendList
import com.example.donggukton.util.extension.ItemDiffCallback
import com.example.donggukton.util.extension.setOnSingleClickListener

class AddFriendAdapter(
    private val onClick: (String, String) -> Unit,
    private val deleteFriend: (String) -> Unit,
) : ListAdapter<FriendList.FriendData, AddFriendAdapter.AddFriendViewHolder>(
    ItemDiffCallback<FriendList.FriendData>(
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

        fun onBind(data: FriendList.FriendData) {
            binding.tvItemName.text = String.format("%s 님", data.nickname)

            if (data.complete == 0) {
                val color = Color.parseColor("#707070")
                binding.clFriend.background.setTint(color)
                binding.tvItemGotoFriend.isEnabled = false
            }

            binding.tvItemGotoFriend.setOnSingleClickListener {
                onClick(data.id, data.nickname)
            }
            binding.tvItemDeleteFriend.setOnSingleClickListener {
                deleteFriend(data.id)
            }
        }
    }
}
