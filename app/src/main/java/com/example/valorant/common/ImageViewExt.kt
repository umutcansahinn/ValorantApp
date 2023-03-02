package com.example.valorant.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.valorant.R

fun ImageView.loadImage(url: String?) {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .circleCrop()
            .placeholder(R.drawable.baseline_cached_24)
            .into(this)
    }
