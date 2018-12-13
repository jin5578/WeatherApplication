package com.tistory.jeongs0222.weatherapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tistory.jeongs0222.weatherapplication.R
import com.tistory.jeongs0222.weatherapplication.databinding.ShortforecastItemBinding
import com.tistory.jeongs0222.weatherapplication.model.shortForecast.ShortForecastResult
import com.tistory.jeongs0222.weatherapplication.ui.viewmodel.MainShortForecastViewModel


class ShortForecastAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var tItem: MutableList<ShortForecastResult> = ArrayList()

    private var sItem: MutableList<ShortForecastResult> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: ShortforecastItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.shortforecast_item, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.setIsRecyclable(false)

        (holder as ViewHolder).bind(tItem[position], sItem[position])
    }

    override fun getItemCount(): Int {
        return if (tItem.isEmpty()) {
            0
        } else {
            tItem.size
        }
    }

    fun addItems(items: ShortForecastResult) {
        if(items.category == "T1H") {
            tItem.add(items)
        } else {
            sItem.add(items)
        }

        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ShortforecastItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val mainShortForecastViewModel = MainShortForecastViewModel()

        fun bind(tItem: ShortForecastResult, sItem: ShortForecastResult) {
            mainShortForecastViewModel.bind(tItem, sItem)

            binding.mainShortForecastViewModel = mainShortForecastViewModel
        }
    }
}