package com.tistory.jeongs0222.weatherapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.tistory.jeongs0222.weatherapplication.R
import com.tistory.jeongs0222.weatherapplication.databinding.MainFinedustLayoutBinding
import com.tistory.jeongs0222.weatherapplication.ui.viewmodel.MainFinedustViewModel


class FinedustAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val binding : MainFinedustLayoutBinding = DataBindingUtil.inflate(layoutInflater, R.layout.finedust_item, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = 0

    class ViewHolder(private val binding: MainFinedustLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        private val mainFinedustViewModel = MainFinedustViewModel()

        fun bind() {

        }
    }
}