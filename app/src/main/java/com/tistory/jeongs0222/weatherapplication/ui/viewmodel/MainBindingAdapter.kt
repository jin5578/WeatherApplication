package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.tistory.jeongs0222.weatherapplication.R


@BindingAdapter("skyUrl")
fun setSkyUrl(view: ImageView, status: String?) {
    if (status != null) {
        when (status) {
            "1" ->
                Glide.with(view)
                    .load(R.drawable.sun)
                    .into(view)
            "2" ->
                Glide.with(view)
                    .load(R.drawable.cloudy)
                    .into(view)

            "3" ->
                Glide.with(view)
                    .load(R.drawable.cloudy1)
                    .into(view)
            "4" ->
                Glide.with(view)
                    .load(R.drawable.cloudy2)
                    .into(view)
        }
    } else {

    }
}