package com.example.donggukton.util

import android.view.LayoutInflater
import com.example.donggukton.R
import com.google.android.material.chip.Chip

object ChipFactory {
    fun create(layoutInflater: LayoutInflater): Chip =
        layoutInflater.inflate(R.layout.view_friend_chip, null, false) as Chip
}
