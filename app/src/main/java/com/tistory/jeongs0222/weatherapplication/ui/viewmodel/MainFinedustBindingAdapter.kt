package com.tistory.jeongs0222.weatherapplication.ui.viewmodel

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tistory.jeongs0222.weatherapplication.R


@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, imageUrl: String?) {
    /*Glide.with(view.context)
        .asBitmap()
        //.load("")
        .apply(RequestOptions()
            .placeholder(R.drawable.soso)
        )
        .into(view)*/
    if(imageUrl != null) {
        Glide.with(view.context)
            .load("")
            .apply(RequestOptions()
                .placeholder(R.drawable.soso))
            .into(view)

    }


}