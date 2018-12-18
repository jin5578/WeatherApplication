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

    private var cItem = ArrayList<String>()
    private var tItem = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: MediumforecastItemBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.mediumforecast_item, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.setIsRecyclable(false)

        Log.e("2112", "2112")

        if(cItem.isNotEmpty() && tItem.isNotEmpty()) {
            Log.e("12121212", "12121212")
            (holder as ViewHolder).bind(cItem[position], position, tItem)
        }

        /*if(cItem.isNotEmpty()) {
            (holder as ViewHolder).bind(cItem[position], position)
        }*/
    }

    override fun getItemCount(): Int = cItem.size

    fun addItems(cItem: ArrayList<String>, tItem: ArrayList<String>) {
        this.cItem = cItem
        this.tItem = tItem

        notifyDataSetChanged()
    }

    /*fun addItems(cItem: ArrayList<String>) {
        this.cItem = cItem

        notifyDataSetChanged()
    }*/

    class ViewHolder(private val binding: MediumforecastItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val mainMediumForecastViewModel = MainMediumForecastViewModel()

        /*fun bind(cItem: String, position: Int, tItem: ArrayList<String>) {
            mainMediumForecastViewModel.bind(cItem, position, tItem)
            mainMediumForecastViewModel.bind(cItem, position)

            binding.viewModel = mainMediumForecastViewModel
        }*/

        fun bind(cItem: String, position: Int, tItem: ArrayList<String>) {
            mainMediumForecastViewModel.bind(cItem, position, tItem)

            binding.viewModel = mainMediumForecastViewModel
        }
    }

}