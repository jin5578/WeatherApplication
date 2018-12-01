package com.tistory.jeongs0222.weatherapplication.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tistory.jeongs0222.weatherapplication.R
import com.tistory.jeongs0222.weatherapplication.databinding.ShortforecastItemBinding
import com.tistory.jeongs0222.weatherapplication.model.shortForecast.ShortForecastItem
import com.tistory.jeongs0222.weatherapplication.model.shortForecast.ShortForecastResult
import com.tistory.jeongs0222.weatherapplication.ui.viewmodel.MainShortForecastViewModel


class ShortForecastAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mItem: MutableList<ShortForecastResult> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: ShortforecastItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.shortforecast_item, parent, false)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder.setIsRecyclable(false)

        Log.e("size", mItem.size.toString())
        (holder as ViewHolder).bind(mItem[position])

        //(holder as ViewHolder).bind(mItem[position])
    }

    override fun getItemCount(): Int {
        return if (mItem.isEmpty()) {
            0
        } else {
            mItem.size
        }
    }

    fun addItems(items: ShortForecastResult) {
        mItem.add(items)

        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ShortforecastItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val mainShortForecastViewModel = MainShortForecastViewModel()



        fun bind(mItem: ShortForecastResult) {
            mainShortForecastViewModel.bind(mItem)

            binding.mainShortForecastViewModel = mainShortForecastViewModel
        }
    }


}