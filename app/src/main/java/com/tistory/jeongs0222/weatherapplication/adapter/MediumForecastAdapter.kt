package com.tistory.jeongs0222.weatherapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tistory.jeongs0222.weatherapplication.R
import com.tistory.jeongs0222.weatherapplication.databinding.MediumforecastItemBinding
import com.tistory.jeongs0222.weatherapplication.model.mediumForecast.MediumForecastResult
import com.tistory.jeongs0222.weatherapplication.ui.viewmodel.MainMediumForecastViewModel


class MediumForecastAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //private var sItem: MediumForecastResult? = null

    private var sItem = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: MediumforecastItemBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.mediumforecast_item, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.setIsRecyclable(false)

        Log.e("2112", "2112")

        if(sItem.isNotEmpty()) {
            (holder as ViewHolder).bind(sItem[position], position)
        }

        /*sItem?.let {
            Log.e("1221", "1221")
            (holder as ViewHolder).bind(it[position])
        }*/

    }

    override fun getItemCount(): Int = sItem.size

    fun addItems(items: ArrayList<String>) {
        //sItem = items
        sItem = items

        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: MediumforecastItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val mainMediumForecastViewModel = MainMediumForecastViewModel()

        fun bind(sItem: String, position: Int) {
            mainMediumForecastViewModel.bind(sItem, position)

            binding.mediumViewModel = mainMediumForecastViewModel
        }
    }

}