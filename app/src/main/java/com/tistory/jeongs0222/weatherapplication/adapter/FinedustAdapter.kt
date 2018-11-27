package com.tistory.jeongs0222.weatherapplication.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tistory.jeongs0222.weatherapplication.R
import com.tistory.jeongs0222.weatherapplication.databinding.FinedustItemBinding
import com.tistory.jeongs0222.weatherapplication.model.finedust.FinedustResult
import com.tistory.jeongs0222.weatherapplication.ui.viewmodel.MainFinedustViewModel


class FinedustAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mItem: FinedustResult? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding: FinedustItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.finedust_item, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        mItem?.let {
            Log.e("123", "123")
            (holder as ViewHolder).bind(it)
        }
    }

    override fun getItemCount(): Int = 1

    fun addItems(items: FinedustResult) {

        mItem = items
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: FinedustItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private val mainFinedustViewModel = MainFinedustViewModel()

        fun bind(mItem: FinedustResult) {
            mainFinedustViewModel.bind(mItem)

            binding.mainFinedustViewModel = mainFinedustViewModel
        }
    }
}