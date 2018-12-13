package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.tistory.jeongs0222.weatherapplication.R


@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, status: Int?) {
    if (status != null) {
        when (status) {
            0 ->
                Glide.with(view.context)
                    .load(R.drawable.good)
                    .into(view)

            1 ->
                Glide.with(view.context)
                    .load(R.drawable.soso)
                    .into(view)

            2 ->
                Glide.with(view.context)
                    .load(R.drawable.bad)
                    .into(view)

            3 ->
                Glide.with(view.context)
                    .load(R.drawable.verybad)
                    .into(view)
        }
    } else {
        Log.e("null", "null")
    }
}