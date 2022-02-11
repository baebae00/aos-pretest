package com.study.aos.quest.util

import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.study.aos.quest.R

object BindingAdapters {

    @BindingAdapter("setSrcFromUrl")
    @JvmStatic
    fun setSrcFromUrl(imageView: ImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .centerCrop()
            .into(imageView)
    }

    @BindingAdapter("setScore")
    @JvmStatic
    fun setScore(textView: TextView, scrore : String) {
        textView.text = "별점: " + scrore + "점"
    }
}