package com.bangkitdicoding.utils

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide.with(this.context)
        .load(url)
        .circleCrop()
        .into(this)
}
